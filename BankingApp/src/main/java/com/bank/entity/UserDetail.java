package com.bank.entity;

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

import lombok.Data;

@Entity
@Table(name = "USER_DETAIL")
@Data
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull(message = "first name can't be empty")
	private String firstName;

	@NotNull(message = "last name can't be empty")
	private String lastName;

	@NotNull(message = "gender can't be empty")
	private String gender;

	@Email(message = "Invalid Email")
	@NotNull(message = "email can't be empty")
	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true, nullable = false)
	@Size(min = 10, max = 10)
	@NotNull(message = "pan number can't be empty")
	private String pan;

	@Column(unique = true, nullable = false)
	@Size(min = 10, max = 15)
	@NotNull(message = "contact number can't be empty")
	private String contact;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_no", referencedColumnName = "account_no")
	private AccountDetail accountDetail;

}
