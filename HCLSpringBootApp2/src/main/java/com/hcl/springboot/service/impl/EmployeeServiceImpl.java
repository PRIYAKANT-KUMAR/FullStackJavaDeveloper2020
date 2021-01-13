package com.hcl.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.springboot.dto.EmployeeDto;
import com.hcl.springboot.entity.Employee;
import com.hcl.springboot.repository.EmployeeRepository;
import com.hcl.springboot.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> findEmployeesByFirstName(String firstName) {
		List<Employee> employees = employeeRepository.findEmployeesByFirstName(firstName);
		return employees;
	}

	@Override
	public List<Employee> findEmployeesByLastName(String lastName) {

		List<Employee> employees = employeeRepository.findEmployeesByLastName(lastName);
		return employees;
	}

	@Override
	public List<Employee> findEmployeesByFirstNameAndLastName(String firstName, String lastName) {

		List<Employee> employees = employeeRepository.findEmployeesByFirstNameAndLastName(firstName, lastName);
		return employees;
	}

	@Override
	public List<Employee> findEmployeesByFirstNameOrLastName(String firstName, String lastName) {
		List<Employee> employees = employeeRepository.findEmployeesByFirstNameOrLastName(firstName, lastName);
		return employees;
	}

	@Override
	@Transactional
	public Integer updateEmployee(Integer age, Integer salary, Long id) {		
		return employeeRepository.updateEmployee(age, salary, id);
	}

	@Override
	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		//return employeeRepository.deleteEmployee(id);
	}

	@Override
	public List<EmployeeDto> getCustomEmployee(Integer age) {
		return employeeRepository.getCustomEmployee(age);
	}

	
}
