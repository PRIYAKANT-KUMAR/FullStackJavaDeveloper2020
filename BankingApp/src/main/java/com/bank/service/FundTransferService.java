package com.bank.service;

public interface FundTransferService {

	public Integer sendMoney(String fromAccountNo, String toAccountNo, Integer amount, String remarks);
	
}
