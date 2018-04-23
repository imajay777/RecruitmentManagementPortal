package com.rmportal.controller;

import org.springframework.data.solr.core.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="EmployeeReferal Controller", description="Refer the Candidate")
@CrossOrigin("*")
public class EmployeeReferalController {
	
	@RequestMapping(value="/getEmployeeDetails/{referal_id}" value=RequestMethod.)

}
