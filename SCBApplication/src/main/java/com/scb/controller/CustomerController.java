package com.scb.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.Customer;
import com.scb.service.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Transactional
	@PostMapping("/create")	
	public String createCustomer(@RequestBody Customer customer) {
		
		return customerService.saveCustomer(customer);
	}
	
	
	
	

}
