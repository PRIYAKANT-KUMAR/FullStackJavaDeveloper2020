package com.mst.employee.managment.repo;

import org.springframework.data.repository.CrudRepository;

import com.mst.employee.managment.entity.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer>{

}
