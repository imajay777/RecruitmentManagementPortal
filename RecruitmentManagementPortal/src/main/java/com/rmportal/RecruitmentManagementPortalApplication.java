package com.rmportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class RecruitmentManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentManagementPortalApplication.class, args);
	}
	
/*	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}*/
}
