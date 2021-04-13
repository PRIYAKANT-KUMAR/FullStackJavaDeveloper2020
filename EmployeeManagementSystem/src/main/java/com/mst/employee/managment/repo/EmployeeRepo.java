package com.mst.employee.managment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mst.employee.managment.entity.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
