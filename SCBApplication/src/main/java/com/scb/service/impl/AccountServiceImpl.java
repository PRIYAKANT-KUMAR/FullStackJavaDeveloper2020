package com.scb.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

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

		if (account1.getBalance().compareTo(amount) == 1) {
			BigDecimal fromBalance = account1.getBalance().subtract(amount);
			BigDecimal toBalance = account2.getBalance().add(amount);

			ACTransaction tx1 = accountRepository.findByAccountId(account1.getAccountId());
			tx1.setTxType("Debit");
			tx1.setTxDate(LocalDateTime.now());

			ACTransaction tx2 = accountRepository.findByAccountId(account2.getAccountId());
			tx2.setTxType("Credit");
			tx2.setTxDate(LocalDateTime.now());

			account1.setBalance(fromBalance);
			account2.setBalance(toBalance);

			account1.getAcTransaction().add(tx1);
			account2.getAcTransaction().add(tx2);

			this.updateAccount(account1);

			System.out.println("Source Account updated");
			this.updateAccount(account2);
			System.out.println("Destination Account updated");

			return "Transaction Success";
		} else {
			return "Insufficient Balance";
		}

	}

	@Override
	public Account getAccountByAccountNumber(Integer accountNumber) {
		return accountRepository.getAccountByAccountNumber(accountNumber);
	}

	@Transactional
	@Override
	public void updateAccount(Account account) {

		accountRepository.updateAccount(account.getAccountId(), account.getBalance());
	}

}
