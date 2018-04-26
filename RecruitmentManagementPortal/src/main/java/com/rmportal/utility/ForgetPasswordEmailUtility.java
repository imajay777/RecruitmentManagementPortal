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
public class ForgetPasswordEmailUtility {

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	UserTokenRepository userTokenRepo;

	@Value("${email.resetPasswordLink}")
	private String resetPasswordLink;

	public void sendMail(User user) {

		if (user != null) {
			String subject = "Reset Password Link for Recruitment Management Portal";
			String message = "Hi " + user.getFirstname() + ", \n"
					+ "\n Welcome to AGSFT Recruitment Management Portal \n Please click on the Reset Password link below to reset your password \n";
			String token = String.valueOf(UUID.randomUUID());

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject(subject);
			mailMessage.setText(message + resetPasswordLink + "/" + user.getId() + "/" + token);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			System.out.println("Email Sender : " +emailSender);
			emailSender.send(mailMessage);

			UserToken userToken = new UserToken();
			userToken.setToken(token);
			userToken.setUser_id(user.getId());
			userToken.setTokenType(UserTokenType.RESET_PASSWORD.name());
			userTokenRepo.save(userToken);
		}

	}
}
