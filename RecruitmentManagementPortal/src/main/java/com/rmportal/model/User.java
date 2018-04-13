package com.rmportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





/**
 * @author tejas
 *
 */

@Table(name = "user")
@Entity
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
	private boolean active;
	
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


	public boolean isActive() {
		return active;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
