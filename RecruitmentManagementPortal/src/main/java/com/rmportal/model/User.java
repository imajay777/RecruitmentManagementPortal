package com.rmportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;





/**
 * @author tejas
 *
 */

@Table(name = "user")
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	int id;

	@Column(name = "user_name")
	//@NotEmpty(message = "*Please provide your user name")
	String username;

	@Column(name = "first_name")
	//@NotEmpty(message = "*Please provide your first name")
	String firstname;

	@Column(name = "last_name")
	//@NotEmpty(message = "*Please provide your last name")
	String lastname;

	@Column(name = "password")
	String password;

	@Column(name = "email")
	//@Email(message = "*Please provide a valid Email")
	//@NotEmpty(message = "*Please provide an email")
	String email;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="role_id")
	//@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Role roles;

	//@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)

	/*public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
*/


	

	
}
