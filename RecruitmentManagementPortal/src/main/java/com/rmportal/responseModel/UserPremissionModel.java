package com.rmportal.responseModel;

import lombok.Data;

@Data
public class UserPremissionModel {
	
	boolean AddUser;
	boolean AddPosition;
	boolean UpdateUser;
	boolean UpdateStatus;
	boolean DeactivateUser;
	boolean ChangeRole;	
}
