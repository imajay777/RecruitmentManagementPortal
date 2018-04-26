package com.rmportal.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeBonusStatusResponseModel {
 
	int referal_id;
	
	String bonus_status;
}
