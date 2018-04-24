package com.rmportal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.model.User;

@Repository
public interface EmployeeReferalRepository extends CrudRepository<EmployeeReferal, Integer>{
	

	EmployeeReferal save(EmployeeReferal employeeReferal);
	
	@Query(value = "SELECT * FROM employee_referal WHERE referal_id =:referal_id", nativeQuery = true)
	User findByEmployeeId(@Param("referal_id") int referalId);

	@Query(value = "SELECT * FROM employee_referal WHERE referance_email =:referance_email", nativeQuery = true)
	EmployeeReferal findByReferalEmail(@Param("referance_email")String referance_email);
}
