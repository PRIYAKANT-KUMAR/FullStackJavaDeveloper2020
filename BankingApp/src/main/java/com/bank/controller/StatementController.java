package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.TransactionDetail;
import com.bank.service.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementController {

	@Autowired
	private StatementService statementService;

	@GetMapping("/stmt")
	public ResponseEntity<List<TransactionDetail>> getStatement(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("accountNo") Integer accountNo) {

		List<TransactionDetail> transactionDetails = statementService.getStatement(startDate, endDate, accountNo);

		return new ResponseEntity<List<TransactionDetail>>(transactionDetails, HttpStatus.OK);
	}

}
