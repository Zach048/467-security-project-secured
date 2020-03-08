/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
//	public Customer getCustomer(Integer id) {
//		String query = "SELECT id, first_name, last_name, username, password, email, phone FROM customer WHERE id = " + id;
//		return template.queryForObject(query,(rs, rowNum) ->
//		new Customer(
//				rs.getInt("id"),
//				rs.getString("username"),
//				rs.getString("password"),
//				rs.getString("first_name"),
//				rs.getString("last_name"),
//				rs.getString("email"),
//				rs.getString("phone")
//			)
//		);	
//	}
//	
//	public Integer login(String userName, String password) {
//		String query = "SELECT id, first_name, last_name, username, password, email, phone FROM customer WHERE username = " + "'"+userName+"'";
//		System.out.println(query);
//			Customer c = template.queryForObject(query,(rs, rowNum) ->
//			new Customer(
//					rs.getInt("id"),
//					rs.getString("username"),
//					rs.getString("password"),
//					rs.getString("first_name"),
//					rs.getString("last_name"),
//					rs.getString("email"),
//					rs.getString("phone")
//				)
//			);
//		// authenticate customer 
//		if(c.getCustomerId() != null && password.equals(c.getPassword())) {
//			return c.getCustomerId();
//		}
////		else if(c.getCustomerId() == null) {
////			c.setFirstName("John");
////			c.setLastName("Doe");
////			c.setEmail("john.doe@oregonstate.edu");
////			c.setPhone("555-555-5555");
////			addCustomer(c);
////			
////			Account newCustomerAccount = new Account(null, RandomStringUtils.random(9, "1234567890"), RandomStringUtils.random(16, "1234567890"), 1650.00, 1230.00, c.getCustomerId(), 4);
////			accountDao.addAccount(newCustomerAccount);
////			
////			return c.getCustomerId();
////		}
//		// customer failed authentication
//		else {
//			return -1;
//		}
//	}
//	
//	public void addCustomer(Customer c) {
//		String query = "INSERT INTO customer (first_name, last_name, username, password, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
//		template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), c.getPassword(), c.getEmail(), c.getPhone());
//	}
//	
//	public void updateCustomer(Customer c) {
//		String query = "UPDATE customer SET first_name = ?, last_name = ?, username = ?, password = ?, email = ?, phone = ? WHERE id = ?";
//		template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), c.getPassword(), c.getEmail(), c.getPhone(), c.getCustomerId());
//
//	}
	
	public CustomerRecord getCustomer(Integer id) {
		String sql = "FROM CustomerRecord WHERE id = :id";
		TypedQuery<CustomerRecord> query = entityManager.createQuery(sql, CustomerRecord.class);
		return query.setParameter("id", id).getSingleResult();
	}
}
