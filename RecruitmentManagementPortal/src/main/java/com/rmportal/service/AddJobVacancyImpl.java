package com.rmportal.service;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rmportal.model.JobVacancy;
import com.rmportal.repository.JobVacancyRepository;
import com.rmportal.requestModel.JobVacancyRequestModel;
import com.rmportal.responseModel.AddJobVacancyResponse;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;



/**
 * @author saurabh
 *
 */
@Service
public class AddJobVacancyImpl implements AddJobVacancyService {

	@Autowired
	JobVacancyRepository jobVacancyRepository;

	@Autowired
	ConversionUtility conversionUtility;

	
	@Override
	public AddJobVacancyResponse addVacancy(JobVacancyRequestModel jobVacancyRequestModel) throws CustomException {

		AddJobVacancyResponse addJobVacancyResponse = new AddJobVacancyResponse();
		JobVacancy jobVacancy = conversionUtility.addJobVacancy(jobVacancyRequestModel);
		if (Objects.isNull(jobVacancy)) {
			throw new CustomException(501, "Error in JOB Posting.");
		}

		jobVacancyRepository.save(jobVacancy);
		addJobVacancyResponse.setJob_id(jobVacancy.getJob_vacancy_id());
		addJobVacancyResponse.setJob_title(jobVacancy.getJob_title());
		addJobVacancyResponse.setMessage("Job Added Succesfully");
		return addJobVacancyResponse;
	}


	@Override
	public AddJobVacancyResponse updateJobVacancy(int job_vacancy_id,@Valid JobVacancyRequestModel jobVacancyRequestModel)
			throws CustomException {

		return null;
	}


	

}
