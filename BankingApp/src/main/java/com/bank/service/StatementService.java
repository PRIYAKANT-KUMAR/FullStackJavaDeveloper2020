package com.bank.service;

import java.util.List;

import com.bank.entity.TransactionDetail;

public interface StatementService {
	List<TransactionDetail> getStatement(String startDate,String endDate, Integer accountNo);

}
