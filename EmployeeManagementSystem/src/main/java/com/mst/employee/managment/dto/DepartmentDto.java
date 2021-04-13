package com.mst.employee.managment.dto;

import javax.validation.constraints.NotEmpty;

public class DepartmentDto {
	@NotEmpty(message = "Designation is required")
	private String departmentName;

}
