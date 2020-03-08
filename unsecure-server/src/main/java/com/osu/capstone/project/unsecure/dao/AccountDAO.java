/**
 * 
 */
package com.osu.capstone.project.unsecure.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.jasypt.util.text.BasicTextEncryptor;

import com.osu.capstone.project.unsecure.dto.Account;
import com.osu.capstone.project.unsecure.dto.Transactions;

/**
 * Represents an interface between the {@link Account} DTO and the underlying database table.
 * @author Zach Earl
 */

@Repository
public class AccountDAO {
	
	public String encrypt(String toEncrypt) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("${jasypt.encryptor.password}");
		return textEncryptor.encrypt(toEncrypt);
	}
	

	public String decryption(String toDecrypt) {
		BasicTextEncryptor textDecryptor = new BasicTextEncryptor();
		textDecryptor.setPassword("${jasypt.encryptor.password}");
		return textDecryptor.decrypt(toDecrypt);
		
	}
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired 
	private TransactionsDAO transactionsDao;
	
	public Account getAccount(Integer customerId) {
		String query = "SELECT id, customer_id, checking_balance, credit_card_balance, " + 
						"credit_card, checking_account FROM account WHERE id = " + customerId;
		Account a = template.queryForObject(query,(rs, rowNum) ->
		new Account(
				rs.getInt("id"),
				rs.getString("checking_account"),
				rs.getString("credit_card"),
				rs.getDouble("checking_balance"),
				rs.getDouble("credit_card_balance"),
				rs.getInt("customer_id")
			)
		);	
		
		/*
		a.setCheckingAccount(encrypt(a.getCheckingAccount()));
		a.setCreditCard(encrypt(a.getCreditCard()));
		System.out.println("Encrypted Account: " + a.getCheckingAccount());
		System.out.println("Encrypted Card: " + a.getCreditCard());
		a.setCheckingAccount(b.decrypt(a.getCheckingAccount()));
		a.setCreditCard(b.decrypt(a.getCreditCard()));
		System.out.println("Decrypted Account: " + a.getCheckingAccount());
		System.out.println("Decrypted Card: " + a.getCreditCard());
		*/
		
		return a;
	}
	
	public void addAccount(Account a) {
		String query = "INSERT INTO account (customer_id, checking_balance, credit_card_balance, credit_card, checking_account) VALUES(?, ?, ?, ?, ?)";
		template.update(query, a.getCustomerId(), a.getCheckingBalance(), a.getCreditCardBalance(), a.getCreditCard(), a.getCheckingAccount());
	}
	
	public void updateAccount(Account a) {
		String query = "UPDATE account SET customer_id = ?, checking_balance = ?, credit_card_balance = ?, credit_card = ?, checking_account = ? WHERE id = ?";
		template.update(query, a.getCustomerId(), a.getCheckingBalance(), a.getCreditCardBalance(), a.getCreditCard(), a.getCheckingAccount(), a.getAccountId());
	}
	
	public void payBalance(Double amountPaid, Account a) {
		// set new credit card balance
		a.setCreditCardBalance(a.getCreditCardBalance() - amountPaid);
		//set new checking account balance
		a.setCheckingBalance(a.getCheckingBalance() - amountPaid);
		// update account to reflect new balance 
		updateAccount(a);
		Transactions creditCardPayment = new Transactions(null, a.getAccountId(), "Credit Card Payment", amountPaid);
		// add credit card payment to customer's transactions
		transactionsDao.addTransaction(creditCardPayment);
	}
}
