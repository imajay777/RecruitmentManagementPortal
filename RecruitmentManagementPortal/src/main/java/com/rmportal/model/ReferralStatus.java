package com.rmportal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.Data;

@Table(name = "referral_status")
@Entity
@Data
public class ReferralStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "referral_id")
	private int referral_id;

	@Column(name = "referral_status")
	private String referral_status;

}
