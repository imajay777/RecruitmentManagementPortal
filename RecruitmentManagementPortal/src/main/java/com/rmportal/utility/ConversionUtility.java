package com.rmportal.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmportal.model.Permission;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.requestModel.UpdateRequestModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.responseModel.RoleResponseModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.responseModel.UserPremissionModel;
import com.rmportal.responseModel.UserResponseDTO;

/**
 * @author tejas
 *
 */
@Component
public class ConversionUtility {

	@Autowired
	PasswordEncryption passwordEncryption;

	public User convertRequestToUser(RegisterRequestModel registerRequestModel) {

		User user = new User();
		user.setEmail(registerRequestModel.getEmail());
		user.setFirstname(registerRequestModel.getFirstname());
		user.setLastname(registerRequestModel.getLastname());
		System.out.println(registerRequestModel.getPassword());
		user.setPassword(passwordEncryption.hashEncoder(registerRequestModel.getPassword()));

		return user;
	}

	public UserResponseDTO convertUserToresponse(User user) {

		UserResponseDTO userResponseDTO = new UserResponseDTO();

		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setFirstname(user.getFirstname());
		userResponseDTO.setLastname(user.getLastname());

		return userResponseDTO;

	}

	public UpdateResponseModel convertForUpdateResponse(User user) {
		UpdateResponseModel updateResponseModel = new UpdateResponseModel();
		updateResponseModel.setEmployee_id(user.getEmployee_id());
		updateResponseModel.setFirst_name(user.getFirstname());
		updateResponseModel.setLast_name(user.getLastname());
		updateResponseModel.setAddress(user.getAddress());
		updateResponseModel.setCity(user.getCity());
		updateResponseModel.setCountry(user.getCountry());
		// updateResponseModel.setDepartment(user.getDepartment());
		updateResponseModel.setDOB(user.getDOB());
		updateResponseModel.setMobile(user.getMobile());
		updateResponseModel.setEmail(user.getEmail());
		return updateResponseModel;
	}

	public ResponseModel convertUserToLoginResponse(User userFromTable) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setEmail(userFromTable.getEmail());
		responseModel.setFirst_name(userFromTable.getFirstname());
		responseModel.setLast_name(userFromTable.getLastname());
		responseModel.setUser_id(userFromTable.getId());
		responseModel.setRole(userFromTable.getRoles());
		responseModel.setPermissions(getPermission(userFromTable.getRoles().getRolePermission()));
		//responseModel.setRoles(userFromTable.getRoles());
		return responseModel;

	}

	// getPermission method for above method(convertUserToLoginResponse)
	public UserPremissionModel getPermission(List<Permission> list) {
		UserPremissionModel model = new UserPremissionModel();
			
		for (Permission permission : list) {
			// String permission1;
			if (permission.getPremissionName() == "AddUser") {
				model.setAddUser(true);
				if (permission.getPremissionName() == "AddUser") {
					model.setAddUser(true);
				}
				if (permission.getPremissionName() == ("AddPosition")) {
					model.setAddPosition(true);
				}
				if (permission.getPremissionName() == ("UpdateUser")) {
					model.setUpdateUser(true);
				}
				if (permission.getPremissionName() == ("UpdateStatus")) {
					model.setUpdateStatus(true);
				}
				if (permission.getPremissionName() == ("DeactivateUser")) {
					model.setDeactivateUser(true);
				}
				if (permission.getPremissionName() == ("ChangeRole")) {
					model.setChangeRole(true);
				}

			}
			if (permission.getPremissionName() == ("AddPosition")) {
				model.setAddUser(true);
			}
			if (permission.getPremissionName() == ("UpdateUser")) {
				model.setAddUser(true);
			}
			if (permission.getPremissionName() == ("UpdateStatus")) {
				model.setAddUser(true);
			}
			if (permission.getPremissionName() == ("DeactivateUser")) {
				model.setAddUser(true);
			}
			if (permission.getPremissionName() == ("ChangeRole")) {
				model.setAddUser(true);
			}
		}
		return model;
	}

	public String setStatusToUser() {

		User user = new User();
		user.setActive(true);
		return "UserActivated";
	}

	// Method for Update Status
	public User convertRequestToUser(UpdateRequestModel updateRequestModel) {

		User user = new User();
		// user.setId(user.getId());
		user.setFirstname(updateRequestModel.getFirst_name());
		user.setEmail(updateRequestModel.getEmail());
		user.setLastname(updateRequestModel.getLast_name());
		user.setAddress(updateRequestModel.getAddress());
		user.setCity(updateRequestModel.getCity());
		user.setCountry(updateRequestModel.getCountry());
		// user.setDepartment(updateRequestModel.getDepartment());
		user.setDOB(updateRequestModel.getDateOfBirth());
		user.setMobile(updateRequestModel.getMobile());
		System.out.println(user);
		return user;

	}

	// Method for List of Roles
	public List<RoleResponseModel> convertToRoleResponseModel(List<Role> roles) {
		List<RoleResponseModel> roleResponseList = new ArrayList<>();
		for (Role role : roles) {
			RoleResponseModel roleResponseModel = new RoleResponseModel();
			roleResponseModel.setId(role.getId());
			roleResponseModel.setRole(role.getRole());
			roleResponseList.add(roleResponseModel);
		}
		return roleResponseList;
	}

}
