package com.scb.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.entity.ACTransaction;
import com.scb.entity.Account;
import com.scb.repository.AccountRepository;
import com.scb.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public String sendMoney(Integer fromAccount, Integer toAccount, BigDecimal amount) {

		Account account1 = this.getAccountByAccountNumber(fromAccount);
		Account account2 = this.getAccountByAccountNumber(toAccount);

		BigDecimal fromBalance = account1.getBalance().subtract(amount);
		BigDecimal toBalance = account2.getBalance().add(amount);

		ACTransaction tx1 = new ACTransaction();
		tx1.setTxType("Debit");
		tx1.setTxDate(LocalDateTime.now());

		ACTransaction tx2 = new ACTransaction();
		tx2.setTxType("Credit");
		tx2.setTxDate(LocalDateTime.now());

		account1.setBalance(fromBalance);
		account2.setBalance(toBalance);

		account1.getAcTransaction().add(tx1);
		account2.getAcTransaction().add(tx2);

		this.updateAccount(account1);
		this.updateAccount(account2);

		return "Transaction Success";
	}

	@Override
	public Account getAccountByAccountNumber(Integer accountNumber) {
		return accountRepository.getAccountByAccountNumber(accountNumber);
	}

	@Override
	public Account updateAccount(Account account) {
		
		return accountRepository.save(account);
	}

}
