package com.rmportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rmportal.model.JobVacancy;

@Repository
public interface JobVacancyRepository extends CrudRepository<JobVacancy, Integer>{

	
	

}
