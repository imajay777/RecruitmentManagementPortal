package com.rmportal.utility;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rmportal.model.EmployeeReferal;

@Component
public class CronJobSchedular {

	@Autowired
	EmailReminder emailReminder;
	
	private static final Logger log = LoggerFactory.getLogger(CronJobSchedular.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${cronjob.hourly.time}")
    public void sendReminderMail(EmployeeReferal employeeReferal) {
        emailReminder.sendMail(employeeReferal);
    }

	
}
