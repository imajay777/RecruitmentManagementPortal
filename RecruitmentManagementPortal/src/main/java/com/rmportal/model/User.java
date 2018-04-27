package com.rmportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tejas
 *
 */

@Table(name = "user")
@Entity
@Data
@EqualsAndHashCode(exclude="roles")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	int id;

	/*
	 * @Column(name = "user_name") //@NotEmpty(message =
	 * "*Please provide your user name") String username;
	 */

	@Column(name = "first_name")
	// @NotEmpty(message = "*Please provide your first name")
	String firstName;

	@Column(name = "last_name")
	// @NotEmpty(message = "*Please provide your last name")
	String lastName;

	@Column(name = "password")
	String password;

	@Column(name = "email")
	// @Email(message = "*Please provide a valid Email")
	// @NotEmpty(message = "*Please provide an email")
	String email;

	@Column(name = "address")
	String address;

	@Column(name = "dob")
	String DOB;

	@Column(name = "city")
	String city;

	@Column(name = "country")
	String country;

	@Column(name = "mobile")
	long mobile;

	@Column(name = "blood_group")
	String blood_group;

	@Column(name = "employee_id")
	String employee_id;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	@JsonManagedReference
	// @JoinTable(name = "user_role", joinColumns = @JoinColumn(name =
	// "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Role roles;

	// @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	@JsonManagedReference
	Department departments;

	
}
