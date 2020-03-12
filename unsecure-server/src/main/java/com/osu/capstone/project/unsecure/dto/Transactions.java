/**
 * 
 */
package com.osu.capstone.project.unsecure.dto;

import com.osu.capstone.project.unsecure.record.TransactionsRecord;

/**
 * The purpose of this class is to decouple the underlying database structure from the 
 * data available to the end user.
 * @author Zach Earl
 */
public class Transactions {
	private Integer transactionId;
	private Integer accountId;
	private String vendorName;
	private Double amountPaid;
	
	public Transactions(TransactionsRecord transaction) {
		this.transactionId = transaction.getTransactionId();
		this.accountId = transaction.getAccount().getAccountId();
		this.vendorName = transaction.getVendorName();
		this.amountPaid = transaction.getAmountPaid();
	}
	
	public Transactions(Integer transactionId, Integer accountId, String vendorName, Double amountPaid) {
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.vendorName = vendorName;
		this.amountPaid = amountPaid;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
	}
}
