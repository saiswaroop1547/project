package com.apn.bo;

/* This is the class for transactionBO class */

public class TransactionBO {
	private String accountNo;
	private String transactionType;
	private String transactionDescription;
	public TransactionBO() {
		super();
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public TransactionBO(String accountNo, String transactionType, String transactionDescription) {
		super();
		
		this.accountNo = accountNo;
		this.transactionType = transactionType;
		this.transactionDescription = transactionDescription;
	}
}
