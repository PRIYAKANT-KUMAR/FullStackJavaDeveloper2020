package com.scb.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scb.entity.ACTransaction;
import com.scb.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);
	
	@Query(value= "select * from actransaction where acc_id=:accountId", nativeQuery = true)
	public ACTransaction findByAccountId(@Param("accountId") Long accountId);

	@Modifying
	@Query(value = "UPDATE account SET balance =:balance WHERE account_id =: accountId", nativeQuery = true)	
	public void updateAccount(@Param("accountId")Long accountId, @Param("balance") BigDecimal balance);

}
