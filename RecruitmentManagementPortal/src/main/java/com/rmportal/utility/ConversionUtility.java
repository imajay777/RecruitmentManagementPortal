package com.rmportal.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmportal.model.JobVacancy;
import com.rmportal.model.Permission;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.JobVacancyRequestModel;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.requestModel.UpdateRequestModel;
import com.rmportal.responseModel.JobVacancyResponseModel;
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
		updateResponseModel.setDOB(user.getDOB());
		updateResponseModel.setMobile(user.getMobile());
		updateResponseModel.setEmail(user.getEmail());
		updateResponseModel.setRole(user.getRoles().getRole());
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
	
	// Add Job Vacancies
	public JobVacancy addJobVacancy(JobVacancyRequestModel jobVacancyRequestModel){
		JobVacancy jobVacancy = new JobVacancy();
		jobVacancy.setJob_title(jobVacancyRequestModel.getJob_title());
		jobVacancy.setNumber_of_openings(jobVacancyRequestModel.getNumber_of_openings());
		jobVacancy.setExperience_required(jobVacancyRequestModel.getExperience_required());
		jobVacancy.setJob_description(jobVacancyRequestModel.getJob_description());
		jobVacancy.setTechnical_skills(jobVacancyRequestModel.getTechnical_skills());
		jobVacancy.setJob_location(jobVacancyRequestModel.getJob_location());
		System.out.println(jobVacancyRequestModel.getSalary_ctc()+"not disclosed");
		if(jobVacancyRequestModel.getSalary_ctc()=="")
		{
			System.out.println("sajay");
			jobVacancy.setSalary_ctc("Not Disclosed");
		}
		else
		{
			jobVacancy.setSalary_ctc(jobVacancyRequestModel.getSalary_ctc());
		}

		
		jobVacancy.setEducation(jobVacancyRequestModel.getEducation());
		jobVacancy.setJob_type(jobVacancyRequestModel.getJob_type());
		return jobVacancy;
	}

	
	// List of job vacancy
	public List<JobVacancyResponseModel> getAllJobVacancy(List<JobVacancy> jobVacancylist){
		//JobVacancy jobVacancy = new JobVacancy();
		List<JobVacancyResponseModel> jobresponselist=new ArrayList<>();
		
	for (JobVacancy jobVacancy : jobVacancylist) {
		JobVacancyResponseModel jobVacancyResponse=new JobVacancyResponseModel();
		jobVacancyResponse.setJob_title(jobVacancy.getJob_title());	
		jobVacancyResponse.setNumber_of_openings(jobVacancy.getNumber_of_openings());
		jobVacancyResponse.setExperience_required(jobVacancy.getExperience_required());
		jobVacancyResponse.setJob_description(jobVacancy.getJob_description());
		jobVacancyResponse.setTechnical_skills(jobVacancy.getTechnical_skills());
		jobVacancyResponse.setSalary_ctc(jobVacancy.getSalary_ctc());
		System.out.println(jobVacancy.getSalary_ctc());
		if( jobVacancy.getSalary_ctc()==null || jobVacancy.getSalary_ctc()=="")
		{
			jobVacancyResponse.setSalary_ctc("Not Disclosed");
		}
		else
		{
			jobVacancyResponse.setSalary_ctc(jobVacancy.getSalary_ctc());
		}
		jobVacancyResponse.setEducation(jobVacancy.getEducation());
		jobVacancyResponse.setJob_type(jobVacancy.getJob_type());
		jobVacancyResponse.setJob_location(jobVacancy.getJob_location());
		jobresponselist.add(jobVacancyResponse);
		
	}
		return jobresponselist;
		
		
		
		
	}

}
