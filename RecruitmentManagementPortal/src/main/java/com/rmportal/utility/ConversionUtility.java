package com.rmportal.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.model.JobVacancy;
import com.rmportal.model.Permission;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.JobVacancyRequestModel;
import com.rmportal.requestModel.ReferralStatusRequestModel;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.requestModel.UpdateRequestModel;
import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
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

	// Registration
	public User convertRequestToUser(RegisterRequestModel registerRequestModel) {

		User user = new User();
		user.setEmail(registerRequestModel.getEmail());
		user.setFirstName(registerRequestModel.getFirstName());
		user.setLastName(registerRequestModel.getLastName());
		System.out.println(registerRequestModel.getPassword());
		user.setPassword(passwordEncryption.hashEncoder(registerRequestModel.getPassword()));

		return user;
	}

	// Registration Response
	public UserResponseDTO convertUserToresponse(User user) {

		UserResponseDTO userResponseDTO = new UserResponseDTO();

		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setFirstname(user.getFirstName());
		userResponseDTO.setLastname(user.getLastName());

		return userResponseDTO;

	}

	// Update Response for Update Profile
	public UpdateResponseModel convertForUpdateResponse(User user) {
		UpdateResponseModel updateResponseModel = new UpdateResponseModel();
		updateResponseModel.setEmployee_id(user.getEmployee_id());
		updateResponseModel.setFirstName(user.getFirstName());
		updateResponseModel.setLastName(user.getLastName());
		updateResponseModel.setAddress(user.getAddress());
		updateResponseModel.setCity(user.getCity());
		updateResponseModel.setCountry(user.getCountry());
		updateResponseModel.setDOB(user.getDOB());
		updateResponseModel.setMobile(user.getMobile());
		updateResponseModel.setEmail(user.getEmail());
	//	updateResponseModel.setDepartment(user.getDepartments());
		updateResponseModel.setBlood_group(user.getBlood_group());
	//	updateResponseModel.setRoles(user.getRoles().getRole());
		return updateResponseModel;
	}
	
	

	// Login Response
	public ResponseModel convertUserToLoginResponse(User userFromTable) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setEmail(userFromTable.getEmail());
		responseModel.setFirstName(userFromTable.getFirstName());
		responseModel.setLastName(userFromTable.getLastName());
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
				if(permission.getPremissionName()=="UpdatePosition") {
				
					model.setUpdatePosition(true);
				}
			
				if(permission.getPremissionName()=="ViewPosition"){
					model.setViewPosition(true);
				}
				if(permission.getPremissionName()=="ChangeStatus"){
					model.setChangeStatus(true);
				}
				
				
			}
		}
		return model;
	}

	// Activate user through profile
	public String setStatusToUser() {

		User user = new User();
		user.setActive(true);
		return "UserActivated";
	}

	// Method for Update Status
	public User convertRequestToUser(UpdateRequestModel updateRequestModel, User user) {

		System.out.println("firstname : " + updateRequestModel.getFirstName());
		user.setFirstName(updateRequestModel.getFirstName());
		user.setLastName(updateRequestModel.getLastName());
		user.setAddress(updateRequestModel.getAddress());
		user.setCity(updateRequestModel.getCity());
		user.setCountry(updateRequestModel.getCountry());
		user.setDOB(updateRequestModel.getDateOfBirth());
		user.setMobile(updateRequestModel.getMobile());
		user.setBlood_group(updateRequestModel.getBlood_group());
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
	public JobVacancy addJobVacancy(JobVacancyRequestModel jobVacancyRequestModel) {
		JobVacancy jobVacancy = new JobVacancy();
		jobVacancy.setJob_title(jobVacancyRequestModel.getJob_title());
		jobVacancy.setNumber_of_openings(jobVacancyRequestModel.getNumber_of_openings());
		jobVacancy.setExperience_required(jobVacancyRequestModel.getExperience_required());
		jobVacancy.setJob_description(jobVacancyRequestModel.getJob_description());
		jobVacancy.setTechnical_skills(jobVacancyRequestModel.getTechnical_skills());
		jobVacancy.setJob_location(jobVacancyRequestModel.getJob_location());
		if (jobVacancyRequestModel.getSalary_ctc() == "" || jobVacancyRequestModel.getSalary_ctc() == " ") {
			jobVacancy.setSalary_ctc("Not Disclosed");
		} else {
			jobVacancy.setSalary_ctc(jobVacancyRequestModel.getSalary_ctc());
		}
		jobVacancy.setEducation(jobVacancyRequestModel.getEducation());
		jobVacancy.setJob_type(jobVacancyRequestModel.getJob_type());
		jobVacancy.setActive(true);
		return jobVacancy;
	}

	// List of job vacancy
	public List<JobVacancyResponseModel> getAllJobVacancy(List<JobVacancy> jobVacancylist) {
		List<JobVacancyResponseModel> jobresponselist = new ArrayList<>();

		for (JobVacancy jobVacancy : jobVacancylist) {
			if (jobVacancy.isActive()) {
				JobVacancyResponseModel jobVacancyResponse = new JobVacancyResponseModel();
				jobVacancyResponse.setJob_vacancy_id(jobVacancy.getJob_vacancy_id());
				jobVacancyResponse.setJob_title(jobVacancy.getJob_title());
				jobVacancyResponse.setNumber_of_openings(jobVacancy.getNumber_of_openings());
				jobVacancyResponse.setExperience_required(jobVacancy.getExperience_required());
				jobVacancyResponse.setJob_description(jobVacancy.getJob_description());
				jobVacancyResponse.setTechnical_skills(jobVacancy.getTechnical_skills());
				jobVacancyResponse.setSalary_ctc(jobVacancy.getSalary_ctc());
				// System.out.println(jobVacancy.getSalary_ctc());
				if (jobVacancy.getSalary_ctc() == null || jobVacancy.getSalary_ctc() == "") {
					jobVacancyResponse.setSalary_ctc("Not Disclosed");
				} else {
					jobVacancyResponse.setSalary_ctc(jobVacancy.getSalary_ctc());
				}
				jobVacancyResponse.setEducation(jobVacancy.getEducation());
				jobVacancyResponse.setJob_type(jobVacancy.getJob_type());
				jobVacancyResponse.setJob_location(jobVacancy.getJob_location());
				jobresponselist.add(jobVacancyResponse);
				System.out.println(jobresponselist);
			}
		}
		return jobresponselist;

	}

	// Get My Candidate Referral list 
	public List<EmployeeReferalResponseModel> convertTOGetEmployees(List<EmployeeReferal> employeeReferalList) {
		List<EmployeeReferalResponseModel> employeeReferalResponselist = new ArrayList<>();
		for (EmployeeReferal employeeReferal : employeeReferalList) {
			EmployeeReferalResponseModel employeeReferalResponseModel = new EmployeeReferalResponseModel();
			employeeReferalResponseModel.setReferal_id(employeeReferal.getReferal_id());
			employeeReferalResponseModel.setApplicant_name(employeeReferal.getApplicant_name());
			employeeReferalResponseModel.setExperience(employeeReferal.getExperience());
			employeeReferalResponseModel.setTechnical_skill(employeeReferal.getTechnical_skill());
			employeeReferalResponseModel.setResume(employeeReferal.getApplicant_name() + " Resume");
			employeeReferalResponseModel.setApplication_status(employeeReferal.getApplication_status());
			employeeReferalResponseModel.setJob_id(employeeReferal.getJob_id());
			employeeReferalResponseModel.setBonous_status(employeeReferal.getBonous_status());
			employeeReferalResponseModel.setDate(employeeReferal.getDate());
			employeeReferalResponselist.add(employeeReferalResponseModel);

		}
		return employeeReferalResponselist;

	}

	// Add Resume
	public EmployeeReferal addEmployeeResume(UploadResumeRequestModel uploadResumeRequestModel, MultipartFile file)
			throws IOException {
		EmployeeReferal employeeReferal = new EmployeeReferal();
		employeeReferal.setApplicant_name(uploadResumeRequestModel.getApplicant_name());
		employeeReferal.setExperience(uploadResumeRequestModel.getExperience());
		employeeReferal.setTechnical_skill(uploadResumeRequestModel.getTechnical_skills());
		employeeReferal.setReferance_email(uploadResumeRequestModel.getEmail());
		Date date = new Date();
		employeeReferal.setDate(date);
		employeeReferal.setApplication_status("In Progress");

		if (!file.isEmpty()) {

			if (!file.getOriginalFilename().equals("")) {
				employeeReferal.setResume(file.getBytes());
			}
		}

		return employeeReferal;
	}

	// Get all employee referal list
	public List<EmployeeReferalResponseModel> getAllEmployeeReferal(List<EmployeeReferal> employeeReferalList) {
		List<EmployeeReferalResponseModel> employeeReferalResponselist = new ArrayList<>();
		for (EmployeeReferal employeeReferal : employeeReferalList) {
			EmployeeReferalResponseModel employeeReferalResponseModel = new EmployeeReferalResponseModel();
			employeeReferalResponseModel.setReferal_id(employeeReferal.getReferal_id());
			employeeReferalResponseModel.setApplicant_name(employeeReferal.getApplicant_name());
			employeeReferalResponseModel.setExperience(employeeReferal.getExperience());
			employeeReferalResponseModel.setTechnical_skill(employeeReferal.getTechnical_skill());
			employeeReferalResponseModel.setResume(employeeReferal.getApplicant_name() + " Resume");
			employeeReferalResponseModel.setApplication_status(employeeReferal.getApplication_status());
			employeeReferalResponseModel.setJob_id(employeeReferal.getJob_id());
			employeeReferalResponseModel.setBonous_status(employeeReferal.getBonous_status());
			employeeReferalResponseModel.setDate(employeeReferal.getDate());
			employeeReferalResponselist.add(employeeReferalResponseModel);

		}
		return employeeReferalResponselist;

	}

	// Response model for Update Profile
	public UpdateResponseModel convertToUpdateResponseModel(User user) {

		UpdateResponseModel updateResponseModel = new UpdateResponseModel();
		updateResponseModel.setFirstName(user.getFirstName());
		updateResponseModel.setLastName(user.getLastName());
		updateResponseModel.setDOB(user.getDOB());
		updateResponseModel.setBlood_group(user.getBlood_group());
		updateResponseModel.setEmail(user.getEmail());
		updateResponseModel.setAddress(user.getAddress());
		updateResponseModel.setCity(user.getCity());
		updateResponseModel.setCountry(user.getCountry());
		updateResponseModel.setMobile(user.getMobile());
		updateResponseModel.setEmployee_id(user.getEmployee_id());
		updateResponseModel.setDepartment(user.getDepartments());
		// updateResponseModel.setRole(user.getRoles());

		return updateResponseModel;

	}

}
