package com.rmportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rmportal.model.EmployeeReferal;

@Repository
public interface EmployeeReferalRepository extends CrudRepository<EmployeeReferal, Integer>{

	<S> S save(EmployeeReferal employeeReferal);
}
