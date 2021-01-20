package com.hcl.springboot.service;

import java.util.List;

import com.hcl.springboot.controller.TransferBalanceRequest;
import com.hcl.springboot.dto.AccountStatement;
import com.hcl.springboot.entity.Account;
import com.hcl.springboot.entity.Transaction;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    );
    AccountStatement getStatement(String accountNumber);
}
