package com.rmportal.requestModel;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UploadResumeRequestModel {

	@NotNull(message = "Internal Error Occured. Please contact to Admin")
	String email;

	@NotNull(message = "Mandatory fields cannot be null")
	String applicant_name;

	@NotNull(message = "Mandatory fields cannot be null")
	int experience;

	@NotNull(message = "Mandatory fields cannot be null")
	String technical_skills;

	//	MultipartFile resume;
	// byte[] resume;

}
