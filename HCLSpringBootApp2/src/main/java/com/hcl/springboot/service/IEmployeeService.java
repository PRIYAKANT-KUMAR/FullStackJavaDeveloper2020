package com.hcl.springboot.service;

import java.util.List;

import com.hcl.springboot.dto.EmployeeDto;
import com.hcl.springboot.entity.Employee;

public interface IEmployeeService {

	public void saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public Employee findEmployeeById(Long id);

	public List<Employee> findEmployeesByFirstName(String firstName);

	public List<Employee> findEmployeesByLastName(String lastName);

	public List<Employee> findEmployeesByFirstNameAndLastName(String firstName, String lastName);

	public List<Employee> findEmployeesByFirstNameOrLastName(String firstName, String lastName);

	public Integer updateEmployee(Integer age, Integer salary, Long id);
	
	public void deleteEmployee(Long id);

	public List<EmployeeDto> getCustomEmployee(Integer age);

}
