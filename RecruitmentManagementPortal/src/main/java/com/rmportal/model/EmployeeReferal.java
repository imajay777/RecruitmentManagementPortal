package com.rmportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "employee_referal")
@Entity
@Data
public class EmployeeReferal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "referal_id")
	int referal_id;

	@Column(name = "applicant_name")
	String applicant_name;

	@Column(name = "experience")
	int experience;

	@Column(name = "technical_skill")
	String technical_skill;

	@Column(name = "referance_email")
	String referance_email;

	@Column(name = "referance_user_id")
	int referance_user_id;
	
	@Column(name="resume")
	@Lob
	byte[] resume;
	
	@Column(name = "application_status")
	String application_status;
	
	@Column(name="status_date")
	Date date;

	@Column(name = "job_id")
	int job_id;

	@Column(name = "bonous_status")
	String bonous_status;
}
