package com.bank.service;

public interface FundTransferService {

	public Integer sendMoney(Integer fromAccountNo, Integer toAccountNo, Integer amount, String remarks);
	
}
