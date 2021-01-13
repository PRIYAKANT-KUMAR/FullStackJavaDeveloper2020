package com.hcl.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.springboot.dto.EmployeeDto;
import com.hcl.springboot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findEmployeesByFirstName(String firstName);

	List<Employee> findEmployeesByLastName(String lastName);

	@Query("from Employee where firstName=:firstName and lastName=:lastName")
	List<Employee> findEmployeesByFirstNameAndLastName(@Param("firstName") String firstName,
			@Param("lastName") String lastName);

	@Query(value = "select * from employee e where e.first_name=:firstName || e.last_name=:lastName", nativeQuery = true)
	List<Employee> findEmployeesByFirstNameOrLastName(String firstName, String lastName);

	@Modifying
	@Query(value = "UPDATE employee SET age =:age, salary =:salary where id =:id", nativeQuery = true)
	Integer updateEmployee(@Param("age") Integer age, @Param("salary") Integer salary, @Param("id") Long id);

	void deleteById(@Param("id") Long id);

	@Query("select new com.hcl.springboot.dto.EmployeeDto(age, count(*)) from Employee where age=:age")
	List<EmployeeDto> getCustomEmployee(@Param("age") Integer age);

}
