package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rmportal.model.EmployeeReferal;

@Component
public class EmailReminder {

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(EmployeeReferal employeeReferal) {

		if (employeeReferal != null) {
			String subject = "Reminder Mail to Transfer Bonus";
			String message = "Hi " + ", \n"
					+ "\n This is the mail from AGSFT Recruitment Management Portal to remind you that "
					+ employeeReferal.getApplicant_name()
					+ " \n have completed his course of duration. \n Transfer the bonus to referee "
					+ employeeReferal.getReferance_email();

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo("jsourabh@agsft.com");
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			emailSender.send(mailMessage);

		}

	}

}
