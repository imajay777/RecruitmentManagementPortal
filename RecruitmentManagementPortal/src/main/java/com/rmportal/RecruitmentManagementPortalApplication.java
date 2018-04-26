package com.rmportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class RecruitmentManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentManagementPortalApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public Docket swaggerIntegration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rmportal.controller")).build().apiInfo(information());

	}

	private ApiInfo information() {

		ApiInfo apiInfo = new ApiInfo("AGSFT RECRUITMENT PORTAL", "Online Portal for Recruitment Management", " ",
				"TOS", "agsft.com", "AGSFT License", "www.agsft.com");
		return apiInfo;
	}

}
