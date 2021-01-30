package com.training.java8.service;

import java.util.List;
import java.util.Map;

import com.training.java8.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee emp);

	List<Employee> getTop5EmployeeByJoiningDate();
	
	public List<Employee> getEmployeesByJoiningDateTime(String date);
	
	public Map<Boolean,List<Employee>> getEmployees();
	
	public List<Employee> getDNACandidates();

}
