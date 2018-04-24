package com.rmportal.requestModel;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UploadResumeRequestModel {

	String email;

	String applicant_name;

	String experience;

	String technical_skills;

	//	MultipartFile resume;
	// byte[] resume;

}
