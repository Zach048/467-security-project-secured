/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.RandomStringUtils;

import com.osu.capstone.project.unsecure.dto.Account;
import com.osu.capstone.project.unsecure.dto.Customer;
import com.osu.capstone.project.unsecure.record.CustomerRecord;
import com.osu.capstone.project.unsecure.dao.AccountDAO;


/**
 * Represents an interface between the {@link Customer} DTO and the underlying database table.
 * @author Zach Earl
 */

@Repository
public class CustomerDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	@PersistenceUnit()
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	AccountDAO accountDao;
	
//	public Integer login(String userName, String password) {
//		String query = "SELECT id, first_name, last_name, username, password, email, phone FROM customer WHERE username = " + "'"+userName+"'";
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
//		//authenticate user
//		if(c.getCustomerId() != null) {
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			//if password has not yet been hashed check for match and hash password
//			if(password.equals(c.getPassword())) {
//				String hashedPassword = passwordEncoder.encode(c.getPassword());
//				query = "UPDATE customer SET password = ? WHERE id = ?";
//				template.update(query, hashedPassword, c.getCustomerId());
//				return c.getCustomerId();
//			}
//			//if password has already been hashed confirm it matches
//			else if(passwordEncoder.matches(password, c.getPassword())) {
//				return c.getCustomerId();
//			}
////			else {
////				return -1;
////			}
//		}
//		return -1;
//	}
	
	/*
	 * TO DO: create account and transactions linked to new user
	 */
//	public void addCustomer(Customer c) {
//		//hash the customer's password
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(c.getPassword());
//		
//		//enter customer information into the database
//		String query = "INSERT INTO customer (first_name, last_name, username, password, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
//		template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone());
//		
//		//create account for the new customer
//		//query = "INSERT INTO account () VALUES()";
//		//template.update(query, );
//		
//		//create record of transactions for the new customer
//		//query = "INSERT INTO transactions () VALUES()";
//		//template.update(query, );
//		
//	}
//
//	
//	public void updateCustomer(Customer c) {
//		//get the current customer password from the database
//		String query = "SELECT password FROM customer WHERE id = " + c.getCustomerId();
//		String currentPassword = template.queryForObject(query,(rs, rowNum) ->
//		new String(
//				rs.getString("password")
//				)
//		);
//		//only update customer information if the password entered is correct
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		if(passwordEncoder.matches(c.getPassword(), currentPassword)) {
//			query = "UPDATE customer SET first_name = ?, last_name = ?, username = ?, password = ?, email = ?, phone = ? WHERE id = ?";
//			//check if customer wants to set new password and hash the new password if so
//			if(c.getNewPassword() != null) {
//				String hashedNewPassword = passwordEncoder.encode(c.getNewPassword());
//				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedNewPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
//			}
//			//otherwise update customer information normally
//			else {
//				String hashedPassword = passwordEncoder.encode(c.getPassword());
//				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
//			}
//		}
//	}
	
	public Customer getCustomer(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = entityManager.find(CustomerRecord.class, id);
		entityManager.detach(c);
		entityManager.close();
		return new Customer(c);
	}
	
	public Integer login(String userName, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "FROM CustomerRecord WHERE userName = :userName";
		TypedQuery<CustomerRecord> query = entityManager.createQuery(sql, CustomerRecord.class);
		query.setParameter("userName", userName);
		CustomerRecord customer = query.getSingleResult();
		Customer c = new Customer(customer);
		//authenticate user
		if(c.getCustomerId() != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			//if password has not yet been hashed check for match and hash password
			if(password.equals(c.getPassword())) {
				String hashedPassword = passwordEncoder.encode(c.getPassword());
				CustomerRecord r = (CustomerRecord)entityManager.getReference(CustomerRecord.class, c.getCustomerId());
				customer.setPassword(hashedPassword);
				entityManager.getTransaction().begin();
				entityManager.persist(r);
				entityManager.getTransaction().commit();
				entityManager.close();
				return c.getCustomerId();
			}
			//if password has already been hashed confirm it matches
			else if(passwordEncoder.matches(password, c.getPassword())) {
				entityManager.close();
				return c.getCustomerId();
			}
//			else {
//				return -1;
//			}
		}
		entityManager.close();
		return -1;
	}
	public void addCustomer(Customer c) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//hash the customer's password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(c.getPassword());
		
		//enter customer information into the database
//		String sql = "FROM CustomerRecord WHERE id = :id";
//		TypedQuery<CustomerRecord> query = entityManager.createQuery(sql, CustomerRecord.class);
//		query.setParameter("id", c.getCustomerId());
		CustomerRecord newRecord = new CustomerRecord(c.getUserName(), hashedPassword, c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone());	
		entityManager.getTransaction().begin();
		entityManager.persist(newRecord);
		entityManager.getTransaction().commit();
		entityManager.close();
		// Add new account
		c.setCustomerId(newRecord.getCustomerId());
		Account newAccount = new Account(null, RandomStringUtils.random(9, "1234567890"), RandomStringUtils.random(16, "1234567890"), 500.00, 25.00, c.getCustomerId());
		accountDao.addAccount(newAccount);
//		template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone());
		
		//create account for the new customer
		//query = "INSERT INTO account () VALUES()";
		//template.update(query, );
		
		//create record of transactions for the new customer
		//query = "INSERT INTO transactions () VALUES()";
		//template.update(query, );
		
	}
	
	public void updateCustomer(Customer customer) {
		//get the current customer password from the database
//		String query = "SELECT password FROM customer WHERE id = " + c.getCustomerId();
//		String currentPassword = template.queryForObject(query,(rs, rowNum) ->
//		new String(
//				rs.getString("password")
//				)
//		);
		
		System.out.println("customer.getPassword() = " + customer.getPassword());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = (CustomerRecord)entityManager.getReference(CustomerRecord.class, customer.getCustomerId());
		System.out.println("customer.getPassword() = " + customer.getPassword());
		System.out.println("c.getPassword() = " + c.getPassword());
		if(customer.getPassword() != null) {
			System.out.println("hashing password...");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(customer.getPassword());
			System.out.println("hashedPassword() = " + hashedPassword);
			c.setUserName(customer.getUserName());
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setEmail(customer.getEmail());
			c.setPhone(customer.getPhone());
			c.setPassword(hashedPassword);
			System.out.println("c.getPassword = " + c.getPassword());
			entityManager.getTransaction().begin();
			entityManager.merge(c);
			entityManager.getTransaction().commit();
		}
		else {
			c.setUserName(customer.getUserName());
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setEmail(customer.getEmail());
			c.setPhone(customer.getPhone());
			entityManager.getTransaction().begin();
			entityManager.merge(c);
			entityManager.getTransaction().commit();
		}
		entityManager.close();
		}
		
		
		
		/*
=======
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = (CustomerRecord)entityManager.getReference(CustomerRecord.class, customer.getCustomerId());
		String currentPassword = c.getPassword();
		System.out.println("Current password: " + c.getPassword());
>>>>>>> a18bccbb1014acc1e0739852ef44c226f6658797
		//only update customer information if the password entered is correct
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("Initialize Bcrypt");
		if(passwordEncoder.matches(customer.getPassword(), currentPassword)) {
			System.out.println("passwords match");
//			query = "UPDATE customer SET first_name = ?, last_name = ?, username = ?, password = ?, email = ?, phone = ? WHERE id = ?";
			//check if customer wants to set new password and hash the new password if so
			if(c.getNewPassword() != null) {
				System.out.println("Password: " + customer.getPassword());
				String hashedNewPassword = passwordEncoder.encode(customer.getPassword());
				c.setUserName(customer.getUserName());
				c.setFirstName(customer.getFirstName());
				c.setLastName(customer.getLastName());
				c.setEmail(customer.getEmail());
				c.setPhone(customer.getPhone());
				c.setPassword(hashedNewPassword);
				entityManager.getTransaction().begin();
				entityManager.merge(c);
				entityManager.getTransaction().commit();

//				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedNewPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
			}
			//otherwise update customer information normally
			else {
				System.out.println(customer.getFirstName());
				String hashedPassword = passwordEncoder.encode(customer.getPassword());
				c.setUserName(customer.getUserName());
				c.setFirstName(customer.getFirstName());
				c.setLastName(customer.getLastName());
				c.setEmail(customer.getEmail());
				c.setPhone(customer.getPhone());
				c.setPassword(hashedPassword);
				entityManager.getTransaction().begin();
				entityManager.merge(c);
				entityManager.getTransaction().commit();
		        System.out.println("after");
//				template.update(query, c.getFirstName(), c.getLastName(), c.getUserName(), hashedPassword, c.getEmail(), c.getPhone(), c.getCustomerId());
			}
		}
		entityManager.close();
	}
<<<<<<< HEAD
	*/

}
