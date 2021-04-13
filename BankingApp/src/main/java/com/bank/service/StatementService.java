package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.entity.TransactionDetail;

public interface StatementService {
	List<TransactionDetail> getStatement(LocalDate startDate, LocalDate endDate, int accountNo);

}
