/**
 * 
 */
package com.osu.capstone.project.unsecure.record;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Zach Earl
 *
 */
@Entity
@Table(name = "account")
public class AccountRecord {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer accountId;
	@Column(name = "checking_account", length = 255)
	private String checkingAccount;
	@Column(name = "credit_card", length = 255)
	private String creditCard;
	@Column(name = "checking_balance")
	private Double checkingBalance;
	@Column(name = "credit_card_balance")
	private Double creditCardBalance;
	@OneToOne(optional = false, cascade= CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerRecord customer;
	
	public AccountRecord(){}
	

	public AccountRecord(String checkingAccount, String creditCard, Double checkingBalance,
			Double creditCardBalance, CustomerRecord customer) {
		this.checkingAccount = checkingAccount;
		this.creditCard = creditCard;
		this.checkingBalance = checkingBalance;
		this.creditCardBalance = creditCardBalance;
		this.customer = customer;
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

	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(Double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public Double getCreditCardBalance() {
		return creditCardBalance;
	}

	public void setCreditCardBalance(Double creditCardBalance) {
		this.creditCardBalance = creditCardBalance;
	}

	public CustomerRecord getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRecord customer) {
		this.customer = customer;
	};

}
