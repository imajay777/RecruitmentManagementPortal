package com.rmportal.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.repository.EmployeeReferalRepository;

@Component
@EnableScheduling
public class CronJobSchedular {

	@Autowired
	EmployeeReferalRepository employeeReferralRepo;
	
	@Autowired
	DateCalculator dateCalculator; 
	
	private static final Logger log = LoggerFactory.getLogger(CronJobSchedular.class);

    @Scheduled(cron = "${cronjob.daily.time}")
    public void sendReminderMail() {
    	
    	List<EmployeeReferal> employeeReferralList = (List<EmployeeReferal>) employeeReferralRepo.findAll();
    	
    	for(EmployeeReferal referralList : employeeReferralList){
			 Date joinedDate = referralList.getDate();
			 dateCalculator.calculateDifferenceBetweenDates(referralList,joinedDate);
    	}
    }

	
}
