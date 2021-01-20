package com.hcl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springboot.dto.AccountStatement;
import com.hcl.springboot.entity.Account;
import com.hcl.springboot.entity.Transaction;
import com.hcl.springboot.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/createAccount")
	public List<Account> create(@RequestBody Account account) {
		accountService.save(account);
		return accountService.findAll();
	}

	@RequestMapping("/showAccount")
	public List<Account> all() {
		return accountService.findAll();
	}

	@PostMapping("/moneyTransfer")
	public ResponseEntity<Transaction> sendMoney(@RequestBody TransferBalanceRequest transferBalanceRequest) {

		return ResponseEntity.ok().body(accountService.sendMoney(transferBalanceRequest));
	}

	@GetMapping("/bankStatement")
	public ResponseEntity<AccountStatement> getStatement(@RequestBody AccountStatementRequest accountStatementRequest) {
		
		return ResponseEntity.ok().body(accountService.getStatement(accountStatementRequest.getAccountNumber()));

	}

}
