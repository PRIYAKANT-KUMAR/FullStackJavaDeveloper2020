package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.UserDetail;
import com.bank.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService accountService;

	@PostMapping("/register-user")
	public ResponseEntity<String> registerUser(@RequestBody UserDetail userDetails) {

		Integer accountNumber = accountService.registerUser(userDetails);
		String message = "Congratulation " + userDetails.getFirstName() + " " + userDetails.getLastName()
				+ "! Your Bank Account has been created successfully and Account Number is " + accountNumber;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
