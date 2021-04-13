package com.bank.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.AccountDetail;

@Repository
public interface FundTransferRepository extends JpaRepository<AccountDetail, Long> {

	@Query(value = "select * from hcl_scb.account_detail where account_no =:accountNo", nativeQuery = true)
	public AccountDetail findByAccountNo(@Param("accountNo") Integer accountNo);

	@Transactional
	@Query(value = "insert into transaction_detail (tx_account_no, amount, tx_date, tx_date_time, tx_type, remarks) values (:txAccountNo, :amount, :txDate, :txDateTime, :txType, :remarks)", nativeQuery = true)
	public void saveTransactionDetails(@Param("txAccountNo") Integer txAccountNo, @Param("amount") Integer amount,
			@Param("txDate") LocalDate txDate, @Param("txDateTime") String txDateTime, @Param("txType") String txType,
			@Param("remarks") String remarks);

}
