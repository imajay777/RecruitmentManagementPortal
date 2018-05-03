package com.rmportal.service;

import java.util.List;

import com.rmportal.responseModel.JobVacancyResponseModel;

public interface ListJobVacancyService {
	
	
	public List<JobVacancyResponseModel> getAllJobs();
	
	public String updateJobStatus(int job_vacancy_id, boolean is_active);
	
	public JobVacancyResponseModel getJobDetails(int job_vacancy_id);
}
