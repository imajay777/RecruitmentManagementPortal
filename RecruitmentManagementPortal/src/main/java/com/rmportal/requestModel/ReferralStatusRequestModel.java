package com.rmportal.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReferralStatusRequestModel {

	int referal_id;
	
	String referral_status;
	
}
