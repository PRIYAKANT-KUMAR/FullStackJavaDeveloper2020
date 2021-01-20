package com.scb.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private LocalDateTime txDate;
	private String txType;

	@ManyToOne
	@JoinColumn(name = "acc_id", nullable = false)
	private Account account;

}
