/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.osu.capstone.project.unsecure.dto.Transactions;
import com.osu.capstone.project.unsecure.record.AccountRecord;
import com.osu.capstone.project.unsecure.record.CustomerRecord;
import com.osu.capstone.project.unsecure.record.TransactionsRecord;

/**
 * Represents an interface between the {@link Transactions} DTO and the underlying database table.
 * @author Zach Earl
 */
@Repository
public class TransactionsDAO {
	
	@PersistenceUnit()
	private EntityManagerFactory entityManagerFactory;
	
	// get customer's transactions
	public List<Transactions> getTransactions(Integer customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerRecord c = (CustomerRecord)entityManager.find(CustomerRecord.class, customerId);
		entityManager.detach(c);
		String sql = "FROM TransactionsRecord t WHERE t.account.customer = :customer";
		TypedQuery<TransactionsRecord> query = entityManager.createQuery(sql, TransactionsRecord.class);
		query.setParameter("customer", c);
		List<TransactionsRecord> t = query.getResultList();
		List<Transactions> transactions = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			transactions.add(new Transactions(t.get(i))); // add TransactionsRecord to associated DTO
		}
		entityManager.close();
		return transactions;
	}
	// add transactions 
	public void addTransaction(Transactions t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		AccountRecord a = (AccountRecord) entityManager.find(AccountRecord.class, t.getAccountId()); // get AccountRecord by id
		TransactionsRecord newRecord = new TransactionsRecord(a, t.getVendorName(), t.getAmountPaid());
		entityManager.getTransaction().begin();
		entityManager.persist(newRecord);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	// update transactions
	public void updateTransaction(Transactions t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TransactionsRecord transaction = (TransactionsRecord) entityManager.getReference(TransactionsRecord.class, t.getTransactionId());
		AccountRecord account = (AccountRecord)entityManager.getReference(AccountRecord.class, t.getAccountId());
		transaction.setVendorName(t.getVendorName());
		transaction.setAmountPaid(t.getAmountPaid());
		transaction.setAccount(account);
		entityManager.getTransaction().begin();
		entityManager.merge(transaction);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
