package com.rmportal.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetBonusRequestModel {

	int referral_id;
	
	String applicant_email;
	
	String bonus_status;
}
