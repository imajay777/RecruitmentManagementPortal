package com.rmportal.utility;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rmportal.constants.UserTokenType;
import com.rmportal.model.User;
import com.rmportal.model.UserToken;
import com.rmportal.repository.UserTokenRepository;

/**
 * @author saurabh
 *
 */
@Component
public class ActivationEmailUtility {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	UserTokenRepository userTokenRepo;
	
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	UserTokenRepository userTokenRepo;

	@Value("${email.activationTokenLink}")
	private String activationLink;

	public void sendMail(User user) {

		if (user != null) {
			String subject = "Activation Link for Recruitment Management Portal";
			String message = "Hi " + user.getFirstname() + ", \n"
					+ "\n Welcome to AGSFT Recruitment Management Portal \n Please click on the activation link below to activate your account \n";
			// String token = RandomStringUtils.randomAlphabetic(8);
			String token = String.valueOf(UUID.randomUUID());

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject(subject);
			mailMessage.setText(message + activationLink + "/" + user.getId() + "/" + token);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			emailSender.send(mailMessage);

			UserToken userToken = new UserToken();
			userToken.setToken(token);
			userToken.setUser_id(user.getId());
			userToken.setTokenType(UserTokenType.ADD_USER.name());
			userTokenRepo.save(userToken);
		}

	}

}
