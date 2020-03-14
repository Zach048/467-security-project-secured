/**
 * 
 */
package com.osu.capstone.project.unsecure.dto;

import com.osu.capstone.project.unsecure.record.AccountRecord;

/**
 * The purpose of this class is to decouple the underlying database structure from the 
 * data available to the end user.
 * @author Zach Earl
 */
public class Account {
	private Integer accountId;
	private String checkingAccount;
	private String creditCard;
	private Double checkingBalance;
	private Double creditCardBalance;
	private Integer customerId;
	
	public Account(AccountRecord account) {
		this.accountId = account.getAccountId();
		this.checkingAccount = account.getCheckingAccount();
		this.creditCard = account.getCreditCard();
		this.checkingBalance = account.getCheckingBalance();
		this.creditCardBalance = account.getCreditCardBalance();
		this.customerId = account.getCustomer().getCustomerId();
	}
	
	public Account(Integer accountId, String checkingAccount, String creditCard, Double checkingBalance, Double creditCardBalance, Integer customerId) {
		this.accountId = accountId;
		this.checkingAccount = checkingAccount;
		this.creditCard = creditCard;
		this.checkingBalance = checkingBalance;
		this.creditCardBalance = creditCardBalance;
		this.customerId = customerId;
	}

	public void setCheckingBalance(Double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public void setCreditCardBalance(Double creditCardBalance) {
		this.creditCardBalance = creditCardBalance;
	}
	
	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public Double getCreditCardBalance() {
		return creditCardBalance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(String checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
