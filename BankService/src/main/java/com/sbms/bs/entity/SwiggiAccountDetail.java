package com.sbms.bs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="swiggi_account_detail")
public class SwiggiAccountDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long swiggiId;
	private String swiggiName;
	private String swiggiAccountNumber;
	private String swiggiContact;
	private Integer swiggiAccountBalance;

}
