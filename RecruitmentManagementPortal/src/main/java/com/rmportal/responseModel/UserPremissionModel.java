package com.rmportal.responseModel;

import com.rmportal.model.Permission;

import lombok.Data;

@Data
public class UserPremissionModel {
	
	boolean AddOpenPosition;
	boolean UpdateOpenPosition;
	boolean ViewOpenPosition;
	boolean ChangeApplicationStatus;
	boolean DeactivateUser;
	boolean AssignRole;	
	boolean ViewResumeStatus;
	boolean ViewBonus;
	boolean AddReferral;
	boolean AddBonusDetails;
	boolean UpdateBonusDetails;
	
	
	
}
