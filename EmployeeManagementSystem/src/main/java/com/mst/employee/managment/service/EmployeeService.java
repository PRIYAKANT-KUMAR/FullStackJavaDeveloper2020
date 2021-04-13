package com.mst.employee.managment.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import com.mst.employee.managment.dto.EmployeeDto;
import com.mst.employee.managment.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();


	HttpStatus updateEmployeeById(EmployeeDto emp, int id);

	Employee getEmployeeById(Integer id);

	Employee createEmployee(@Valid EmployeeDto emp);


	HttpStatus deleteAllEmployees(EmployeeDto emp);


	List<Employee> updateEmployeeById(Employee emp, int id);


	Employee createEmployee(Employee emp);

}
