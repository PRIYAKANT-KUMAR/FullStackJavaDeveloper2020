package com.hcl.springboot.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private Long accountId;
	@Column(unique=true)
	private String accountNumber;
	private BigDecimal currentBalance;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;

}