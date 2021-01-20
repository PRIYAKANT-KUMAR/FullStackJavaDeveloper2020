package com.scb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.ACTransaction;
import com.scb.service.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementController {
	/*
	 * @Autowired public StatementService statementService;
	 * 
	 * @GetMapping("/generate") public ACTransaction getStatement(@RequestParam
	 * Integer accountNumber, @RequestParam String fromDate, @RequestParam String
	 * toDate) {
	 * 
	 * ACTransaction acTransaction = null; acTransaction =
	 * statementService.getStatement(accountNumber,fromDate,toDate); return
	 * acTransaction; }
	 */
}
