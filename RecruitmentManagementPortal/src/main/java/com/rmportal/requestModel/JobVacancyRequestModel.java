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
	@NotNull(message = "Job Title cannot be null")
	String job_title;

	@Min(value = 1, message = "Openings cannot be less than 1")
	@Max(value = 100, message = "Openings cannot be greater than 100")
	int number_of_openings;

	@Size(min = 2, max = 50, message = "Experience field cannot be blank")
	@NotNull(message = "Experience cannot be null")
	String experience_required;

	String job_description;

	@Size(min = 2, max = 200, message = "Technical Skills must contain atleast 2 and atmost 200 characters")
	@NotNull(message = "Technical Skills cannot be null")
	String technical_skills;

	@Size(min = 2, max = 50, message = "Job Location field cannot be blank")
	@NotNull(message = "Job Location cannot be null")
	String job_location;

	String salary_ctc;

	@Size(min = 2, max = 50, message = "Education field cannot be blank")
	@NotNull(message = "Education cannot be null")
	String education;

	@Size(min = 2, max = 50, message = "Job Type cannot be blank")
	@NotNull(message = "Job Type cannot be null")
	String job_type;

}
