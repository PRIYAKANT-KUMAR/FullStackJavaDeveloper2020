package com.training.java8.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.java8.entity.Employee;
import com.training.java8.exception.InvalidDateFormateException;
import com.training.java8.repo.EmployeeRepo;
import com.training.java8.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee createEmployee(Employee emp) {

		String localDate = emp.getJoiningDate().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			emp.setJoiningDate(LocalDate.parse(localDate, formatter));
		} catch (Exception ex) {

			throw new InvalidDateFormateException(ex.getLocalizedMessage());
		}
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getTop5EmployeeByJoiningDate() {
		return empRepo.findAll().stream().sorted((e1, e2) -> e1.getJoiningDate().compareTo(e1.getJoiningDate()))
				.limit(5).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesByJoiningDateTime(String joininDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate;
		try {
			localDate = LocalDate.parse(joininDate, formatter);
		} catch (Exception ex) {
			throw new InvalidDateFormateException(ex.getLocalizedMessage());
		}
		return empRepo.findAll().stream().filter(emp -> emp.getJoiningDate().isEqual(localDate))
				.collect(Collectors.toList());
	}

	@Override
	public Map<Boolean, List<Employee>> getEmployees() {
		return empRepo.findAll().stream().collect(Collectors.groupingBy(Employee::getIsManager));
	}

	@Override
	public List<Employee> getDNACandidates() {
		return empRepo.findAll().stream().filter((emp) -> emp.getWorkExperience() > 7).collect(Collectors.toList());
	}

}
