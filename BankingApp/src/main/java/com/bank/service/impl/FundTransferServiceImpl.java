package com.bank.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.AccountDetail;
import com.bank.entity.TransactionDetail;
import com.bank.exception.BankExceptionHandler;
import com.bank.repo.FundTransferRepository;
import com.bank.repo.StatementRepository;
import com.bank.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Autowired
	private StatementRepository statementRepository;

	@Override
	@Modifying
	@Transactional
	public TransactionDetail sendMoney(int fromAccountNo, int toAccountNo, int amount, String remarks) {
		AccountDetail sourceAccountDetail = null;
		AccountDetail destAccountDetail = null;
		TransactionDetail transactionDetail;
		if (fromAccountNo != toAccountNo) {
			try {
				sourceAccountDetail = fundTransferRepository.findByAccountNo(fromAccountNo);
				destAccountDetail = fundTransferRepository.findByAccountNo(toAccountNo);
			} catch (NullPointerException npe) {
				throw new BankExceptionHandler(
						fromAccountNo + " " + toAccountNo + " account number doesn't exist " + npe.getMessage());
			}

			if (sourceAccountDetail == null && destAccountDetail == null) {
				throw new BankExceptionHandler("account number does not exist");
			}
			if (amount < 1) {
				throw new BankExceptionHandler("amount should greater than 0");
			}

			if (sourceAccountDetail.getBalance() > amount) {
				sourceAccountDetail.setBalance(sourceAccountDetail.getBalance() - amount);
				destAccountDetail.setBalance(destAccountDetail.getBalance() + amount);

				TransactionDetail transactionDetail1 = new TransactionDetail();
				transactionDetail1.setTxAccountNo(fromAccountNo);
				transactionDetail1.setAmount(amount);
				transactionDetail1.setTxDate(LocalDate.now());
				transactionDetail1.setTxDateTime(LocalDateTime.now());
				transactionDetail1.setRemarks(remarks);
				transactionDetail1.setTxType("Debit");

				TransactionDetail transactionDetail2 = new TransactionDetail();
				transactionDetail2.setTxAccountNo(toAccountNo);
				transactionDetail2.setAmount(amount);
				transactionDetail2.setTxDate(LocalDate.now());
				transactionDetail2.setTxDateTime(LocalDateTime.now());
				transactionDetail2.setRemarks(remarks);
				transactionDetail2.setTxType("Credit");

				fundTransferRepository.save(sourceAccountDetail);
				fundTransferRepository.save(destAccountDetail);

				transactionDetail = statementRepository.save(transactionDetail1);
				statementRepository.save(transactionDetail2);

			} else {

				throw new BankExceptionHandler("Insufficient Balance in your account");
			}

		} else {

			throw new BankExceptionHandler("source and destination account number are same");
		}

		return transactionDetail;
	}

}
