package com.rmportal.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rmportal.repository.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

	@Query(value = "SELECT * FROM employee WHERE name =:name AND is_active=1", nativeQuery = true)
	Employee findByName(@Param("name")String name);

}
