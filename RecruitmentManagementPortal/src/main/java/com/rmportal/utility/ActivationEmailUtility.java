package com.rmportal.utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rmportal.model.User;

/**
 * @author saurabh
 *
 */
@Component
public class ActivationEmailUtility {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${email.activationTokenLink}")
	private String activationLink;

	public void sendMail(User user) {

		if (user != null) {
			String subject = "Activation Link for Recruitment Management Portal";
			String message = "Hi " + user.getFirstname() + ", \n"
					+ "\n Welcome to AGSFT Recruitment Management Portal \n Please click on the activation link below to activate your account \n";
			String token = RandomStringUtils.randomAlphabetic(user.getFirstname().length());
			//String link = "http://localhost:8080/activation";
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject(subject);
			mailMessage.setText(message + activationLink + "/" + token);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			emailSender.send(mailMessage);
			System.out.println(activationLink);
		}

	}



}
