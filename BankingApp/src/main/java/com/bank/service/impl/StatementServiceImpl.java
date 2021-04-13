package com.bank.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.TransactionDetail;
import com.bank.exception.BankExceptionHandler;
import com.bank.repo.StatementRepository;
import com.bank.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementRepository statementRepository;

	@Override
	public List<TransactionDetail> getStatement(LocalDate startDate, LocalDate endDate, int accountNo) throws BankExceptionHandler{

		List<TransactionDetail> transactionDetails = null;
		if (endDate.isAfter(startDate) && endDate.isBefore(LocalDate.now()) ) {

			if(!statementRepository.findTransactionDetailByAccountNo(accountNo)) {
				throw new BankExceptionHandler("Invalid account number");
				
			}
			transactionDetails = statementRepository
					.findTransactionDetailByAccountNumberAndDateRange(startDate, endDate, accountNo);
			return transactionDetails;
		}else {
			throw new BankExceptionHandler("end date can not be future date");
		}
	}

}
