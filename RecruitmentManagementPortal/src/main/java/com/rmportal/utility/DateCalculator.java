package com.rmportal.utility;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmportal.model.EmployeeReferal;

@Component
public class DateCalculator {

	@Autowired
	EmailReminder emailReminder;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);

	@Test
	public void calculateDifferenceBetweenDates(EmployeeReferal referralList, Date joinedDate) {

		LocalDate now = LocalDate.now();
		Date input = joinedDate;
		Instant instant = Instant.ofEpochMilli(input.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate joiningDate = localDateTime.toLocalDate();

		Duration duration = Duration.between(now, joiningDate);
//		long diff = Math.abs(duration.toDays());
		long diff = Math.abs(duration.toMinutes());

		if (diff == 45 || diff == 10){
			emailReminder.sendMail(referralList ,diff);
		}
	}

}
