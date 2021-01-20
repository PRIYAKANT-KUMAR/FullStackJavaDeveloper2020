package com.hcl.springboot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.hcl.springboot.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement {

	BigDecimal currentBalance;
    List<Transaction> transactionHistory;
}
