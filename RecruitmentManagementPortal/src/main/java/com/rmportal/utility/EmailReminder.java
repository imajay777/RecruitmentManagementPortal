package com.rmportal.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rmportal.model.EmployeeReferal;

@Component
public class EmailReminder {

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(EmployeeReferal referralList, long diff) {

		if (diff != 0) {
			String subject = "Reminder Mail to Transfer Bonus";
			String message = "Hi " + ", \n"
					+ "\n This is the mail from AGSFT Recruitment Management Portal to remind you that "
					+ referralList.getApplicant_name()
					+ " \n have completed his "+diff+" of duration. \n Transfer the bonus to referee "
					+ referralList.getReferance_email();

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo("jsourabh@agsft.com");
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			emailSender.send(mailMessage);

		}

	}

}
