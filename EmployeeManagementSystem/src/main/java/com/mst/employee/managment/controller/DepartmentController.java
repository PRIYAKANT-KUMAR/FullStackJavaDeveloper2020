package com.mst.employee.managment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mst.employee.managment.dto.EmployeeDto;
import com.mst.employee.managment.entity.Employee;
import com.mst.employee.managment.service.EmployeeService;

public class DepartmentController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);

	}


	@PostMapping("/create-employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto emp) {

		return new ResponseEntity<Employee>(employeeService.createEmployee(emp), HttpStatus.CREATED);
	}

	@PutMapping("/update-employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto emp, @PathVariable int id) {

		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(emp, id));
	}

	@DeleteMapping("/delete-employees")
	public ResponseEntity<Employee> deleteEmployee(@RequestBody EmployeeDto emp) {

		return new ResponseEntity<Employee>(employeeService.deleteAllEmployees(emp));
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeByID( @PathVariable int id) {

		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
}
