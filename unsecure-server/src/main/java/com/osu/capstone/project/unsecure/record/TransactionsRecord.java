package com.osu.capstone.project.unsecure.record;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Zach Earl
 *
 * Represents a single transactions record in the MySQL relational database.
 * Interaction with the underlying database (saving, loading) can be achieved 
 * through the {@link TransactionsDAO} class.
 * RESTful API endpoints for this object are available through the
 * {@link TransactionsController} class.
 */
@Entity
@Table(name = "transactions")
public class TransactionsRecord {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer transactionId;
	@ManyToOne(optional = false, cascade= CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private AccountRecord account;
	@Column(name = "vendor_name")
	private String vendorName;
	@Column(name = "amount_paid")
	private Double amountPaid;
	
	public TransactionsRecord() {}

	public TransactionsRecord(AccountRecord account, String vendorName, Double amountPaid) {
		this.account = account;
		this.vendorName = vendorName;
		this.amountPaid = amountPaid;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public AccountRecord getAccount() {
		return account;
	}

	public void setAccount(AccountRecord account) {
		this.account = account;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	};
	
	

}
