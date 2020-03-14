/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

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
	
	
	@PersistenceUnit()
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	AccountDAO accountDao;
	

	public Customer getCustomer(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = entityManager.find(CustomerRecord.class, id);
		entityManager.detach(c);
		entityManager.close();
		return new Customer(c);
	}
	
	public Integer login(String userName, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "FROM CustomerRecord WHERE userName = :userName"; // get customer by username
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
				customer.setPassword(hashedPassword); // set the new hashed password
				entityManager.getTransaction().begin(); // begin transaction of persisting data
				entityManager.persist(r);
				entityManager.getTransaction().commit(); // committing transaction to database
				entityManager.close();
				return c.getCustomerId();
			}
			//if password has already been hashed confirm it matches
			else if(passwordEncoder.matches(password, c.getPassword())) {
				entityManager.close();
				return c.getCustomerId();
			}
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
		CustomerRecord newRecord = new CustomerRecord(c.getUserName(), hashedPassword, c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone());	
		entityManager.getTransaction().begin();
		entityManager.persist(newRecord);
		entityManager.getTransaction().commit();
		entityManager.close();
		// Add new account
		c.setCustomerId(newRecord.getCustomerId());
		Account newAccount = new Account(null, RandomStringUtils.random(9, "1234567890"), RandomStringUtils.random(16, "1234567890"), 500.00, 25.00, c.getCustomerId());
		accountDao.addAccount(newAccount);
		
	}
	
	public void updateCustomer(Customer customer) {
		//get the current customer password from the database	
//		System.out.println("customer.getPassword() = " + customer.getPassword());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = (CustomerRecord)entityManager.getReference(CustomerRecord.class, customer.getCustomerId());
		System.out.println("customer.getPassword() = " + customer.getPassword());
		System.out.println("c.getPassword() = " + c.getPassword());
		if(customer.getPassword() != null) { // if customer updated password
//			System.out.println("hashing password...");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(customer.getPassword());
//			System.out.println("hashedPassword() = " + hashedPassword);
			c.setUserName(customer.getUserName()); // set properties
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setEmail(customer.getEmail());
			c.setPhone(customer.getPhone());
			c.setPassword(hashedPassword);
//			System.out.println("c.getPassword = " + c.getPassword());
			entityManager.getTransaction().begin(); // persist data
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

}
