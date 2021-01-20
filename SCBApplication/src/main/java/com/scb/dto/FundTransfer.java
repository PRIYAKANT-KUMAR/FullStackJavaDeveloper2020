package com.scb.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class FundTransfer {

	Integer fromAccount;
	Integer toAccount;
	BigDecimal amount;
}
