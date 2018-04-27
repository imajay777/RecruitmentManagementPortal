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
	boolean UpdatePosition;//
	boolean ViewPosition;//
	boolean ChangeStatus;//
	boolean ViewStatus;//	
	
	
	
	
	/*boolean AddUser;
	boolean AddPosition;
	boolean UpdatePosition;//
	boolean ViewPosition;//
	boolean ChangeStatus;//
	boolean ViewStatus;//
	boolean UpdateUser;
	boolean UpdateStatus;
	boolean DeactivateUser;
	boolean ChangeRole;	*/
}
