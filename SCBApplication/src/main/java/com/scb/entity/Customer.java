package com.scb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	@NotNull
	private String name;
	@Column(unique = true, nullable = false)
	@Size(min =10, max=15)
	private String contactNo;
	@Column(unique = true, nullable = false)
	@Size(min =10, max=10)
	private String pan;
	@NotNull
	private String address;
	@Column(unique = true, nullable = false)
	@Email
	private String email;

	public Customer(String name, String contactNo, String pan, String address, String email, Account account) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.pan = pan;
		this.address = address;
		this.email = email;
		this.account = account;
		
	}

	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "acc_id")
    private Account account;

}
