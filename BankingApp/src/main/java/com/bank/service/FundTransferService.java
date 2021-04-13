package com.bank.service;

import com.bank.entity.TransactionDetail;

public interface FundTransferService {

	public TransactionDetail sendMoney(int fromAccountNo, int toAccountNo, int amount, String remarks);
	
}
