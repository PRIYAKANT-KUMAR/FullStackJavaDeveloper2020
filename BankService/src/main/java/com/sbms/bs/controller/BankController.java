package com.sbms.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.bs.entity.SwiggiAccountDetail;
import com.sbms.bs.entity.UserAccountDetail;
import com.sbms.bs.service.BankService;

@RestController
@RequestMapping("/banking")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/create-user-account")
	public ResponseEntity<String> createUserAccount(@RequestBody UserAccountDetail userAccountDetail) {

		return ResponseEntity.ok().body(bankService.createUserAccount(userAccountDetail));
	}

	@PostMapping("/create-swiggi-account")
	public ResponseEntity<String> createSwiggiAccount(@RequestBody SwiggiAccountDetail swiggiAccountDetail) {

		return ResponseEntity.ok().body(bankService.createSwiggiAccount(swiggiAccountDetail));

	}

}
