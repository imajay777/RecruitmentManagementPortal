package com.rmportal.responseModel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateJoinResponseModel {

	int referal_id;
	String applicant_name;

	int experience;

	String technical_skill;
	
	String application_status;

	int job_id;

	Date date;

	String bonous_status;

}
