package com.training.java8.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Designation is required")
	private String designation;

	@NotNull(message = "Contact number is required")
	@Min(value = 10, message = "Contact number must contian minimum 10 digits")
	private Long contactNumber;

	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid Email id")
	private String email;

	@NotNull(message = "isManager is required")
	private Boolean isManager;

	@FutureOrPresent(message = "Joining date is invlaid")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull(message = "Joining date is required")
	// @JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate joiningDate;

	@NotNull(message = "Work Experience is required")
	@Min(value = 1, message = "Work Experience should be gretter than 0")
	private Integer workExperience;

	@NotEmpty(message = "Address is required")
	private String address;

}
