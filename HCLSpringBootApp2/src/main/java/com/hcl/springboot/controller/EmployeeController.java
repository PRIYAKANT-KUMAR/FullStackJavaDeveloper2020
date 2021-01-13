package com.hcl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springboot.dto.EmployeeDto;
import com.hcl.springboot.entity.Employee;
import com.hcl.springboot.service.IEmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	IEmployeeService iemployeeService;

	// Store Emaployee Object into DB table
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		iemployeeService.saveEmployee(employee);
		return "Employee Record is Successfully Saved";
	}

	// Fetch Employees Object from DB table
	@GetMapping("/fetchEmployees")
	public List<Employee> getEmployees() {
		return iemployeeService.getEmployees();
	}

	// Search Employee by Id
	@GetMapping("/findById/{id}")
	public Employee getEmployeesByID(@PathVariable Long id) {
		return iemployeeService.findEmployeeById(id);
	}

	// Search Employees by First Name
	@GetMapping("/search/firstName")
	public List<Employee> getEmployeesByFirstName(@RequestParam String firstName) {
		return iemployeeService.findEmployeesByFirstName(firstName);
	}

	// Search Employees by Last Name
	@GetMapping("/search/lastName")
	public List<Employee> getEmployeesByLastName(@RequestParam String lastName) {
		return iemployeeService.findEmployeesByLastName(lastName);
	}

	// Search Employees by First Name and Last Name
	@GetMapping("/search/fnameAndlname")
	public List<Employee> getEmployeesByFirstNameAndLastName(@RequestParam String firstName,
			@RequestParam String lastName) {
		return iemployeeService.findEmployeesByFirstNameAndLastName(firstName, lastName);
	}

	// Search Employees by either First Name or Last Name
	@GetMapping("/search/fnameOrlname")
	public List<Employee> findEmployeesByFirstNameOrLastName(@RequestParam String firstName,
			@RequestParam String lastName) {
		return iemployeeService.findEmployeesByFirstNameOrLastName(firstName, lastName);
	}

	@PutMapping("/update/{age}/{salary}/{id}")
	public Integer updateEmployee(@PathVariable Integer age, @PathVariable Integer salary, @PathVariable Long id) {
		return iemployeeService.updateEmployee(age, salary, id);
	}

	@DeleteMapping("/remove/{id}")
	void deleteEmployee(@PathVariable Long id) {
		iemployeeService.deleteEmployee(id);
	}

	@GetMapping("/customEmployee/{age}")
	public List<EmployeeDto> getCustomEmployee(@PathVariable Integer age) {
		return iemployeeService.getCustomEmployee(age);
	}

}
