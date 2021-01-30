package com.bank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "account_detail")
@Data
public class AccountDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;

	@NotNull(message = "account number can't be empty")
	@Column(name = "account_no", unique = true)
	private String accountNumber;

	@NotNull(message = "account open date can't be empty")
	@Column(name = "open_date")
	private String openDate;

	@Size(min = 1000)
	@NotNull(message = "account opening balance can't be empty")
	private Integer balance;

	@NotNull(message = "account type can't be empty")
	private String type;

	@NotNull(message = "account status can't be empty")
	private String status;

	//@OneToOne(mappedBy = "accountDetail", cascade = CascadeType.ALL)
	@OneToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "user_id")
	private UserDetail userDetail;

	/*
	 * @PrePersist void preInsert() {
	 * 
	 * if (this.accountNo == null) { Random rand = new Random(); Integer accountNo =
	 * rand.nextInt(10000); this.setAccountNo(String.valueOf(accountNo)); } if
	 * (this.openDate == null) { this.setOpenDate(LocalDate.now().toString()); } if
	 * (this.balance == null) { this.setBalance(1000); } if (this.type == null) {
	 * this.setType("saving"); } if (this.status == null) {
	 * this.setStatus("active"); }
	 * 
	 * }
	 */

}
