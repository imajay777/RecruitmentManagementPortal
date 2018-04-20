package com.rmportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.requestModel.JobVacancyRequestModel;
import com.rmportal.responseModel.AddJobVacancyResponse;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.service.AddJobVacancyService;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Job Vacancy", description = "Job Vacancies")
@CrossOrigin("*")
public class JobVacancyController {

	@Autowired
	AddJobVacancyService addJobVacancyService;

	@RequestMapping(value = "/addJobVacancy", method = RequestMethod.POST)
	@ApiOperation(value = "Add Job Vacencies")
	public ResponseEntity<?> addJobVacancy(@RequestBody JobVacancyRequestModel jobVacancyRequestModel)
			throws CustomException {

		AddJobVacancyResponse addJobVacancyResponse = null;
		addJobVacancyResponse = addJobVacancyService.addVacancy(jobVacancyRequestModel);

		return ResponseEntity.ok(new HttpResponseModel(
				HttpStatusConstants.OK.getStatus() + " New JOB POSTED Successfully", HttpStatusConstants.OK.id, addJobVacancyResponse));
	}

}
