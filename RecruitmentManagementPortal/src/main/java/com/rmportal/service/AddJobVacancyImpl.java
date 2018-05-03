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
import com.rmportal.responseModel.JobVacancyResponseModel;
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

	// update job vacancy
	@Override
	public AddJobVacancyResponse updateJobVacancy(int job_vacancy_id,
			@Valid JobVacancyRequestModel jobVacancyRequestModel) throws CustomException {
		AddJobVacancyResponse addJobVacancyResponse = new AddJobVacancyResponse();
		JobVacancy jobVacancy = jobVacancyRepository.findByJobVacancyId(job_vacancy_id);
		if (jobVacancy != null) {
			if (jobVacancy.getJob_title() == null) {
				throw new CustomException(HttpStatus.NOT_FOUND.value(), " Job title cannot be null");
			} else {
				jobVacancy.setJob_title(jobVacancyRequestModel.getJob_title());
			}
			/*
			 * if(jobVacancy.getExp_to()==0) { throw new
			 * CustomException(HttpStatus.NOT_FOUND.value()
			 * ,"specify the job expreience"); } else {
			 * jobVacancy.setExp_to(jobVacancyRequestModel.getExp_to()); }
			 * 
			 * if(jobVacancy.getExp_from()==0){ throw new
			 * CustomException(HttpStatus.NOT_FOUND.value()
			 * ,"specify the job expreience"); }else{
			 * jobVacancy.setExp_from(jobVacancyRequestModel.getExp_from()); }
			 */

			if (jobVacancy.getEducation() == null) {
				throw new CustomException(HttpStatus.NOT_FOUND.value(), "Mandatory fields canot be Empty");
			} else {
				jobVacancy.setEducation(jobVacancyRequestModel.getEducation());

			}

			jobVacancy.setJob_description(jobVacancyRequestModel.getJob_description());
			if (jobVacancy.getJob_location() == null) {
				throw new CustomException(HttpStatus.NOT_FOUND.value(), "Mandatory fields canot be Empty");
			} else {
				jobVacancy.setJob_location(jobVacancyRequestModel.getJob_location());
			}
			if (jobVacancy.getJob_type() == null) {
				throw new CustomException(HttpStatus.NOT_FOUND.value(), "Mandatory fields canot be Empty");
			} else {
				jobVacancy.setJob_type(jobVacancyRequestModel.getJob_type());
			}

			jobVacancy.setNumber_of_openings(jobVacancyRequestModel.getNumber_of_openings());
			jobVacancy.setSalary_ctc(jobVacancyRequestModel.getSalary_ctc());

			if (jobVacancy.getTechnical_skills() == null) {
				throw new CustomException(HttpStatus.NOT_FOUND.value(), "Mandatory fields canot be Empty");
			} else {
				jobVacancy.setTechnical_skills(jobVacancyRequestModel.getTechnical_skills());
			}

			jobVacancy.setActive(true);
			jobVacancyRepository.save(jobVacancy);
		}
		addJobVacancyResponse.setJob_id(jobVacancy.getJob_vacancy_id());
		if (jobVacancy.getJob_title() == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.value(), "Mandatory fields canot be Empty");
		} else {
			addJobVacancyResponse.setJob_title(jobVacancy.getJob_title());
		}

		addJobVacancyResponse.setMessage("Job Vacancy Updated Succesfully");
		return addJobVacancyResponse;

	}

	
	
	

}
