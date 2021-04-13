package com.mst.employee.managment.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")

	
private int employeeID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender_type")
	private String gender;
	@Column(name="mobile-number")
	private Long mobileNumber;
	@Column(name ="Email")
	private String email;

	@NotNull
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	

}