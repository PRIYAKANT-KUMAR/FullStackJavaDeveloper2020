package com.scb.service;

import java.math.BigDecimal;

import com.scb.entity.Account;

public interface AccountService {

	String sendMoney(Integer fromAccount, Integer toAccount, BigDecimal amount);

	void updateAccount(Account account);

	Account getAccountByAccountNumber(Integer accountNumber);

}
