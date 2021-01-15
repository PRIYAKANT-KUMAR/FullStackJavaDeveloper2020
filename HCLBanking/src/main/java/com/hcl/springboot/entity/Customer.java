package com.hcl.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	private String firstName;
	private String lastName;
	private Long aadhaarNo;
	private String panNo;
	private Long contactNo;
	private String address;
	private AccountDetails accountDetails;
	

	public Customer() {
	}

	public Customer(String firstName, String lastName, Long aadhaarNo, String panNo, Long contactNo, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.aadhaarNo = aadhaarNo;
		this.panNo = panNo;
		this.contactNo = contactNo;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(Long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	
}
