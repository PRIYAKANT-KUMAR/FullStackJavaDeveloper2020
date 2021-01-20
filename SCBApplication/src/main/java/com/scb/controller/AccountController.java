package com.scb.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/sendMoney")
	public String sendMoney(@RequestParam Integer fromAccount, @RequestParam Integer toAccount, @RequestParam BigDecimal amount) {

		return accountService.sendMoney(fromAccount, toAccount, amount);
	}
	
	

}
