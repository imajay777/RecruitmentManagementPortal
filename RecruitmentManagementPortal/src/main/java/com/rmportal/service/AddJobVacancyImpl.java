package com.rmportal.service;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
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
	public AddJobVacancyResponse updateJobVacancy(int job_vacancy_id, JobVacancyRequestModel jobVacancyRequestModel)
			throws CustomException {
		AddJobVacancyResponse addJobVacancyResponse = new AddJobVacancyResponse();
		JobVacancy jobVacancy = jobVacancyRepository.findByJobVacancyId(job_vacancy_id);
		if(jobVacancy!=null)
		{
			if(jobVacancy.getJob_title()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"job title cannot be null");
			}
			else
			{
			jobVacancy.setJob_title(jobVacancyRequestModel.getJob_title());
			}
			if(jobVacancy.getExperience_required()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the job expreience");
			}
			else
			{
				jobVacancy.setExperience_required(jobVacancyRequestModel.getExperience_required());

			}
			if(jobVacancy.getEducation()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the required education");
			}
			else
			{
				jobVacancy.setEducation(jobVacancyRequestModel.getEducation());

			}
		
			jobVacancy.setJob_description(jobVacancyRequestModel.getJob_description());
			if(jobVacancy.getJob_location()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the job location");
			}
			else
			{
			jobVacancy.setJob_location(jobVacancyRequestModel.getJob_location());
			}
			if(jobVacancy.getJob_type()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the job type");
			}
			else
			{
			jobVacancy.setJob_type(jobVacancyRequestModel.getJob_type());
			}
			
			jobVacancy.setNumber_of_openings(jobVacancyRequestModel.getNumber_of_openings());
			jobVacancy.setSalary_ctc(jobVacancyRequestModel.getSalary_ctc());
			
			if(jobVacancy.getTechnical_skills()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the required skill for job");
			}
			else
			{
				jobVacancy.setTechnical_skills(jobVacancyRequestModel.getTechnical_skills());	
			}
			
			jobVacancy.setActive(true);
			jobVacancyRepository.save(jobVacancy);
		}
		addJobVacancyResponse.setJob_id(jobVacancy.getJob_vacancy_id());
		addJobVacancyResponse.setJob_title(jobVacancy.getJob_title());
		addJobVacancyResponse.setMessage("Job Vacancy Updated Succesfully");
		return addJobVacancyResponse;	
		
	}


	

}
