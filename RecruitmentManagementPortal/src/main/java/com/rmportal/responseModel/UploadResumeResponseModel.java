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
public class UploadResumeResponseModel {

	int reference_id;

	String applicant_name;
	
	Date date;
	
	String fileName;
	
	String fileExtension;
}
