package com.scb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.dto.FundTransfer;
import com.scb.repository.AccountRepository;
import com.scb.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	/*
	 * @Override public String sendMoney(FundTransfer fundTransfer) {
	 * 
	 * //return accountRepository.sendMoney(fundTransfer); return "jfkdsjfkd"; }
	 */

}
