package com.rmportal.service;

import java.util.List;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.UpdateRoleRequestModel;
import com.rmportal.responseModel.RoleResponseModel;
import com.rmportal.utility.CustomException;


/**
 * @author saurabh
 *
 */
public interface UpdateRoles {

	
	public List<RoleResponseModel> getAllRoles() throws CustomException;

	List<String> getAllRoleTypes() throws CustomException;
	
	String changeRole(UpdateRoleRequestModel updateRoleRequestModel) throws CustomException;
}
