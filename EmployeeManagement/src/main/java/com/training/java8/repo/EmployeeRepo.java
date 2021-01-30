package com.training.java8.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.java8.entity.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Long>{
	

}
