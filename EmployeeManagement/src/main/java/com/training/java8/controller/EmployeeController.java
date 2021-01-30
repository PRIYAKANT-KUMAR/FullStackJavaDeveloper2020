package com.training.java8.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.java8.dto.EmployeeDto;
import com.training.java8.entity.Employee;
import com.training.java8.service.EmployeeService;

@RestController
@RequestMapping("/java8")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ModelMapper empModelMapper;

	@PostMapping("/create-employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto emp) {

		return new ResponseEntity<Employee>(employeeService.createEmployee(empModelMapper.map(emp, Employee.class)),
				HttpStatus.CREATED);
	}

	@GetMapping("/get-top5-emp-By-JoininDate")
	public ResponseEntity<List<Employee>> getTop5EmployeeByJoiningDate() {

		return new ResponseEntity<List<Employee>>(employeeService.getTop5EmployeeByJoiningDate(), HttpStatus.OK);
	}

	@GetMapping("/get-emp-by-joinigDateTime/{joininDate}")
	public ResponseEntity<List<Employee>> getEmployeeByJoiningDateTime(@PathVariable("joininDate") String joininDate) {

		return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByJoiningDateTime(joininDate),
				HttpStatus.OK);

	}

	@GetMapping("/get-emp-by-designation-category")
	public Map<Boolean, List<Employee>> findAllEmpGroupByCategory() {

		return employeeService.getEmployees();
	}

	@GetMapping("/get-dna-candidates")
	public ResponseEntity<List<Employee>> getAllDNACandidates() {
		return new ResponseEntity<List<Employee>>(employeeService.getDNACandidates(), HttpStatus.OK);
	}

}
