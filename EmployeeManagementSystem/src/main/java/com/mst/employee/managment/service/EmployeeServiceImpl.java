package com.mst.employee.managment.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mst.employee.managment.dto.EmployeeDto;
import com.mst.employee.managment.entity.Employee;
import com.mst.employee.managment.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepo.findById(id);
	}

	
	@Override
	public List<Employee> updateEmployeeById(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			return (List<Employee>) employeeRepo.save(emp);
		}
		return null;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public HttpStatus updateEmployeeById(EmployeeDto emp, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(@Valid EmployeeDto emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpStatus deleteAllEmployees(EmployeeDto emp) {
		// TODO Auto-generated method stub
		return null;
	}


}
