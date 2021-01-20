package com.scb.service.impl;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.entity.Account;
import com.scb.entity.Customer;
import com.scb.repository.CustomerRepository;
import com.scb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String saveCustomer(Customer customer) {

		Random rand = new Random();
		Integer accountNumber = rand.nextInt(100000);
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setBalance(customer.getAccount().getBalance());
		account.setOpenDate(LocalDate.now().toString());
		customer.setAccount(account);

		customerRepository.save(customer);

		System.out.println("Customer and Account has created");

		return "Congratulation!! " + customer.getName() + " Welcome to SCB Your Account Number is "
				+ account.getAccountNumber();
	}

}
