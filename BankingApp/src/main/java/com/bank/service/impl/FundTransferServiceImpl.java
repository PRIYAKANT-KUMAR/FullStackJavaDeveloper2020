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
import com.bank.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Override
	@Modifying
	@Transactional
	public Integer sendMoney(Integer fromAccountNo, Integer toAccountNo, Integer amount, String remarks)
			throws BankExceptionHandler {
		if (fromAccountNo != toAccountNo) {

			AccountDetail sourceAccountDetail = fundTransferRepository.findByAccountNo(fromAccountNo);
			AccountDetail destAccountDetail = fundTransferRepository.findByAccountNo(toAccountNo);
			
			if(sourceAccountDetail == null &&  destAccountDetail==null) {
				throw new BankExceptionHandler("account number does not exist");
			}
			if(amount < 1) {
					throw new BankExceptionHandler("amount should greater than 0");
			}
				
			if (sourceAccountDetail.getBalance() > amount) {
				sourceAccountDetail.setBalance(sourceAccountDetail.getBalance() - amount);
				destAccountDetail.setBalance(destAccountDetail.getBalance() + amount);

				TransactionDetail transactionDetail1 = new TransactionDetail();
				transactionDetail1.setTxAccountNo(fromAccountNo);
				transactionDetail1.setAmount(amount);
				transactionDetail1.setTxDate(LocalDate.now());
				transactionDetail1.setTxDateTime(LocalDateTime.now().toString());
				transactionDetail1.setRemarks(remarks);
				transactionDetail1.setTxType("Debit");

				TransactionDetail transactionDetail2 = new TransactionDetail();
				transactionDetail2.setTxAccountNo(toAccountNo);
				transactionDetail2.setAmount(amount);
				transactionDetail2.setTxDate(LocalDate.now());
				transactionDetail2.setTxDateTime(LocalDateTime.now().toString());
				transactionDetail2.setRemarks(remarks);
				transactionDetail2.setTxType("Credit");

				fundTransferRepository.save(sourceAccountDetail);
				fundTransferRepository.save(destAccountDetail);

				fundTransferRepository.saveTransactionDetails(transactionDetail1.getTxAccountNo(),transactionDetail1.getAmount(), transactionDetail1.getTxDate(), transactionDetail1.getTxDateTime(),transactionDetail1.getTxType(), transactionDetail1.getRemarks());
				fundTransferRepository.saveTransactionDetails(transactionDetail2.getTxAccountNo(),transactionDetail2.getAmount(), transactionDetail2.getTxDate(), transactionDetail2.getTxDateTime(),transactionDetail2.getTxType(), transactionDetail2.getRemarks());
				
			} else {

				throw new BankExceptionHandler("Insufficient Balance in your account");
			}

		} else {

			throw new BankExceptionHandler("source and destination account number are same");
		}

		return 12;
	}

}
