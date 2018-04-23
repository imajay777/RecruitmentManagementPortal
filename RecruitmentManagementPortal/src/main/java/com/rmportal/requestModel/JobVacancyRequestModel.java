package com.rmportal.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobVacancyRequestModel {

	
	String job_title;

	int number_of_openings;

	String experience_required;

	String job_description;

	String technical_skills;
	
	String job_location;

	String salary_ctc;

	String education;

	String job_type;
	
	
}
