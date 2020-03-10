/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.RandomStringUtils;

import com.osu.capstone.project.unsecure.dto.Account;
import com.osu.capstone.project.unsecure.dto.Customer;
import com.osu.capstone.project.unsecure.record.CustomerRecord;

/**
 * Represents an interface between the {@link Customer} DTO and the underlying database table.
 * @author Zach Earl
 */

@Repository
public class CustomerDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Integer login(String userName, String password) {
		String query = "SELECT id, first_name, last_name, username, password, email, phone FROM customer WHERE username = " + "'"+userName+"'";
			Customer c = template.queryForObject(query,(rs, rowNum) ->
			new Customer(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email"),
					rs.getString("phone")
				)
			);
		//authenticate user
		if(c.getCustomerId() != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			//if password has not yet been hashed check for match and hash password
			if(password.equals(c.getPassword())) {
				String hashedPassword = passwordEncoder.encode(c.getPassword());
				query = "UPDATE customer SET password = ? WHERE id = ?";
				template.update(query, hashedPassword, c.getCustomerId());
				return c.getCustomerId();
			}
			//if password has already been hashed confirm it matches
			else if(passwordEncoder.matches(password, c.getPassword())) {
				return c.getCustomerId();
			}
			else {
				return -1;
			}
		}
		return -1;
	}
	
	/*
	 * TO DO: create account and transactions linked to new user
	 */
	public void addCustomer(Customer c) {
		//hash the customer's password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(c.getPassword());
		
		//enter customer information into the database
		String query = "INSERT INTO customer (first_name, last_name, username, password, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
		template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone());
		
		//create account for the new customer
		//query = "INSERT INTO account () VALUES()";
		//template.update(query, );
		
		//create record of transactions for the new customer
		//query = "INSERT INTO transactions () VALUES()";
		//template.update(query, );
		
	}

	
	public void updateCustomer(Customer c) {
		//get the current customer password from the database
		String query = "SELECT password FROM customer WHERE id = " + c.getCustomerId();
		String currentPassword = template.queryForObject(query,(rs, rowNum) ->
		new String(
				rs.getString("password")
				)
		);
		//only update customer information if the password entered is correct
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(c.getPassword(), currentPassword)) {
			query = "UPDATE customer SET first_name = ?, last_name = ?, username = ?, password = ?, email = ?, phone = ? WHERE id = ?";
			//check if customer wants to set new password and hash the new password if so
			if(c.getNewPassword() != null) {
				String hashedNewPassword = passwordEncoder.encode(c.getNewPassword());
				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedNewPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
			}
			//otherwise update customer information normally
			else {
				String hashedPassword = passwordEncoder.encode(c.getPassword());
				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
			}
		}
	}
	
	public CustomerRecord getCustomer(Integer id) {
		String sql = "FROM CustomerRecord WHERE id = :id";
		TypedQuery<CustomerRecord> query = entityManager.createQuery(sql, CustomerRecord.class);
		return query.setParameter("id", id).getSingleResult();
	}
}
