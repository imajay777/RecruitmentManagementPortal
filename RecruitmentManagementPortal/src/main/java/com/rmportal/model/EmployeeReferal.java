package com.rmportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;

import lombok.Data;

@Table(name = "employee_referal")
@Entity
@Data
//@EqualsAndHashCode(exclude="user")
public class EmployeeReferal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "referal_id")
	int referal_id;
	
	@Column(name = "applicant_name")
	String applicant_name;
	
	@Column(name="experience")
	String experience;
	
	@Column(name="technical_skill")
	String technical_skill;
	
	@Column(name="referance_email")
	String referance_email;

	@Column(name="referance_user_id")
	int referance_user_id;
	
	@Column(name="resume")
	@Lob
	Blob resume;
	
	@Column(name="application_status")
	String application_status;
	
	@Column(name="job_id")
	int job_id;
	
	@Column(name="bonous_status")
	String bonous_status;
}
