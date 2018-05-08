package com.rmportal.requestModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobVacancyRequestModel {

	@Size(min = 2, max = 100, message = "Job Title must contain atleast 2 and atmost 100 characters")
	@NotNull(message = "Mandatory field cannot be Empty")
	String job_title;

	@Min(value = 1, message = "Mandatory field cannot be Empty")
	@Max(value = 100, message = "Mandatory field cannot be Empty")
	int number_of_openings;

/*	@Size(min = 1, max = 50, message = "Experience must contain atleast 1 characters")
	@NotNull(message = "Mandatory field cannot be Empty")
	String experience_required;*/

	String job_description;

	@Size(min = 2, max = 200, message = "Technical Skills must contain atleast 2 and atmost 200 characters")
	@NotNull(message = "Mandatory field cannot be Empty")
	String technical_skills;

	@Size(min = 2, max = 50, message = "Job Location must contain atleast 2 characters")
	@NotNull(message = "Mandatory field cannot be Empty")
	String job_location;

//	@Min(value = 0, message = "Mandatory field cannot be Empty")
	String salary_ctc;


	String education;

	String job_type;

	@Min(value = 0, message = "Mandatory field cannot be Empty")
	@Max(value = 100, message = "Mandatory field cannot be Empty")
	int exp_to;
	
	@Min(value = 0, message = "Mandatory field cannot be Empty")
	@Max(value = 100, message = "Mandatory field cannot be Empty")
	int exp_from;
	
}
