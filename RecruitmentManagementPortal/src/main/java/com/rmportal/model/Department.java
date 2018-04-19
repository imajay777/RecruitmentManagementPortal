package com.rmportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="department")
@Data
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id")
	private int dept_id;
	
	@Column(name="dept_name")
	private String dept_name;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "departments")
	List<User> user;
	

}
