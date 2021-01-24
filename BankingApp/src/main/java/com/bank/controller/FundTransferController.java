package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.exception.BankExceptionHandler;
import com.bank.service.FundTransferService;

@RestController
@RequestMapping("/fund-transfer")
public class FundTransferController {

	@Autowired
	private FundTransferService fundTransferService;

	@PutMapping("/send-money")
	public ResponseEntity<String> sendMoney(@RequestParam("fromAccountNo") Integer fromAccountNo,
			@RequestParam("toAccountNo") Integer toAccountNo, @RequestParam("amount") Integer amount,
			@RequestParam("remarks") String remarks) {
		String message;
		try {
			Integer transactionId = fundTransferService.sendMoney(fromAccountNo, toAccountNo, amount, remarks);

			message = "Transaction Successfull for amount " + amount + " and your transaction id is " + transactionId;
		} catch (BankExceptionHandler beh) {
			message = beh.getMessage();
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

}
