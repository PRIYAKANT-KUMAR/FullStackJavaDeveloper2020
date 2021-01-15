package com.hcl.springboot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class AccountDetails {

	private String accountNo;
	private Date accountCreationDate;
	private Long amount;
	private Date amountCreditOrDebit;

	public AccountDetails() {
		super();
	}

	public AccountDetails(String accountNo, Date accountCreationDate, Long amount, Date amountCreditOrDebit) {
		super();
		this.accountNo = accountNo;
		this.accountCreationDate = accountCreationDate;
		this.amount = amount;
		this.amountCreditOrDebit = amountCreditOrDebit;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getAmountCreditOrDebit() {
		return amountCreditOrDebit;
	}

	public void setAmountCreditOrDebit(Date amountCreditOrDebit) {
		this.amountCreditOrDebit = amountCreditOrDebit;
	}

}
