package com.scb.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "actransaction")
public class ACTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txId;
	private BigDecimal txAmount;
	private Timestamp txDate;
	private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private String txType;
    
    //@ManyToOne(cascade = CascadeType.ALL, optional = false)
    //@JoinColumn(name = "acc_id")
    //private Account account;

}
