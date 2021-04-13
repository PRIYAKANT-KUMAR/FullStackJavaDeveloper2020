package com.bank.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.entity.TransactionDetail;

@Repository
public interface StatementRepository extends JpaRepository<TransactionDetail, Long> {

	@Query(value = "select * from transaction_detail where account_no=:accountNo and tx_date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<TransactionDetail> findTransactionDetailByAccountNumberAndDateRange(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("accountNo") int accountNo);

	@Query("from TransactionDetail where accountNo=:accountNo")
	boolean findTransactionDetailByAccountNo(Integer accountNo);

}
