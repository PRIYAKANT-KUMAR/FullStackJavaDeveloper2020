package com.scb.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scb.dto.FundTransfer;
import com.scb.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	/*
	 * public String sendMoney(FundTransfer fundTransfer) {
	 * 
	 * BigDecimal fromAccountBalance =
	 * getAccountBalance(fundTransfer.getFromAccount()); BigDecimal toAccountBalance
	 * = getAccountBalance(fundTransfer.getToAccount());
	 * 
	 * if(fromAccountBalance>fundTransfer.getAmount()) { BigDecimal balance1 =
	 * fromAccountBalance-fundTransfer.getAmount(); BigDecimal balance2 =
	 * toAccountBalance+fundTransfer.getAmount();
	 * 
	 * updateAccountBalance(balance1); updateAccountBalance(balance2);
	 * 
	 * } else { return
	 * "Insufficient Balance in account: "+fundTransfer.getFromAccount(); } return
	 * null; }
	 */

	@Query("select balance from Account where accountNumber=:accountNumber")
	public BigDecimal getAccountBalance(Integer accountNumber);

	@Modifying
	@Query(value = "UPDATE account SET balance =:balance where account_number =:accountNumber", nativeQuery = true)
	Integer updateAccountBalance(@Param("balance") BigDecimal balance);

}
