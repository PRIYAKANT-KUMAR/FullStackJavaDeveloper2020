package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.scb.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

	public Integer updateAccount(Account account);

}
