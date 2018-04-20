package com.rmportal.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AddJobVacancyResponse {

	int job_id;
	String job_title;
	String message;
	
}
