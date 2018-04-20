package com.rmportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rmportal.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{ 

}
