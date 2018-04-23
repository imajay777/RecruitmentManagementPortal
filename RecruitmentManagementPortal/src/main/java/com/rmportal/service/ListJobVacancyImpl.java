package com.rmportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.model.JobVacancy;
import com.rmportal.repository.JobVacancyRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.responseModel.JobVacancyResponseModel;
import com.rmportal.utility.ConversionUtility;

@Service
public class ListJobVacancyImpl implements ListJobVacancyService{

	@Autowired
	JobVacancyRepository jobVacancyRepository;

	@Autowired
	ConversionUtility conversionUtility;
	@Override
	public List<JobVacancyResponseModel> getAllJobs() {
		List<JobVacancy> getJobs = (List<JobVacancy>) jobVacancyRepository.findAll();

		return conversionUtility.getAllJobVacancy(getJobs);
		//return getJobs;
	}
	

}
