package com.scb.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.dto.FundTransfer;
import com.scb.service.AccountService;

@RestController
@RequestMapping("/bankaccount")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/*
	 * @PostMapping("/fund-transfer") public String sendMoney(@RequestBody
	 * FundTransfer fundTransfer) {
	 * 
	 * accountService.sendMoney(fundTransfer); return
	 * "Your transaction has been completed successfully"; }
	 */

}
