package com.sbms.fos.bank.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bank-order-service", url = "http://localhost:8081/api/bank/banking")
public interface BankClient {

	@PostMapping("/book-order")
	public String bookOrder(@RequestParam Long userAccount, @RequestParam Long vendorAccount,
			@RequestParam Long totalAmount);

}
