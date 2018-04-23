package com.rmportal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.model.User;

public interface EmployeeReferalRepository extends CrudRepository<EmployeeReferal, Integer>{
	
	@Query(value = "SELECT * FROM employee_referal WHERE referal_id =:referal_id", nativeQuery = true)
	User findByEmployeeId(@Param("referal_id") int referalId);

}
