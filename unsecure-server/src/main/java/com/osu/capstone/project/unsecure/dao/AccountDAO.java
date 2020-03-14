/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import com.osu.capstone.project.unsecure.dto.Account;
import com.osu.capstone.project.unsecure.dto.Transactions;
import com.osu.capstone.project.unsecure.record.AccountRecord;
import com.osu.capstone.project.unsecure.record.CustomerRecord;

/**
 * Represents an interface between the {@link Account} DTO and the underlying database table.
 * @author Zach Earl
 */

@Repository
public class AccountDAO {
	
	
	@Autowired 
	private TransactionsDAO transactionsDao;
	
	@PersistenceUnit()
	private EntityManagerFactory entityManagerFactory;
	
	public Account getAccount(Integer customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = (CustomerRecord)entityManager.find(CustomerRecord.class, customerId);
		entityManager.detach(c);
		String sql = "FROM AccountRecord WHERE customer = :customer";
		TypedQuery<AccountRecord> query = entityManager.createQuery(sql, AccountRecord.class);
		query.setParameter("customer", c);
		AccountRecord account = query.getSingleResult();
		entityManager.close();
		Account a = new Account(account);
		return a;
		
		
	}
	public void addAccount(Account a) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Customer id: " + a.getCustomerId());
		CustomerRecord c = (CustomerRecord)entityManager.find(CustomerRecord.class, a.getCustomerId());
		AccountRecord newRecord = new AccountRecord(a.getCheckingAccount(), a.getCreditCard(), a.getCheckingBalance(), a.getCreditCardBalance(), c);
		entityManager.getTransaction().begin();
		entityManager.persist(newRecord);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public void updateAccount(Account a) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		AccountRecord account = (AccountRecord)entityManager.find(AccountRecord.class, a.getAccountId());
		entityManager.detach(account);
		CustomerRecord customer = (CustomerRecord)entityManager.find(CustomerRecord.class, a.getCustomerId());
		entityManager.detach(customer);
		account.setCheckingAccount(a.getCheckingAccount());
		account.setCheckingBalance(a.getCheckingBalance());
		account.setCreditCard(a.getCreditCard());
		account.setCreditCardBalance(a.getCreditCardBalance());
		account.setCustomer(customer);
		System.out.println("a: " + String.format("%.0f", a.getCreditCardBalance()));
		System.out.println("r: " + String.format("%.0f", account.getCreditCardBalance()));
		entityManager.getTransaction().begin();
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public void payBalance(Double amountPaid, Account a) {
		// set new credit card balance
		a.setCreditCardBalance(a.getCreditCardBalance() - amountPaid);
		//set new checking account balance
		a.setCheckingBalance(a.getCheckingBalance() - amountPaid);
		// update account to reflect new balance 
		System.out.println("a: " + a.getCreditCardBalance());
		updateAccount(a);
		Transactions creditCardPayment = new Transactions(null, a.getAccountId(), "Credit Card Payment", amountPaid);
		// add credit card payment to customer's transactions
		transactionsDao.addTransaction(creditCardPayment);
	}
	
}
