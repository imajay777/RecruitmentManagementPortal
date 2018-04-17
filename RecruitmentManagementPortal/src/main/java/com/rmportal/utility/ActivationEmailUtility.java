package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void sendMail(User user) {

		if (user != null) {
			String subject = "Activation Link for Recruitment Management Portal";
			String message = "Hi " + user.getFirstname() + ", \n"
					+ "\n Welcome to AGSFT Recruitment Management Portal \n Please click on the activation link below to activate your account \n";
			String link = "http://localhost:8080/activation ";

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject(subject);
			mailMessage.setText(message + link);
			mailMessage.setFrom("no-reply-rpPortal@agsft.com");
			emailSender.send(mailMessage);
		}
	}

	/*
	 * String to = "jsourabh@agsft.com"; String from =
	 * "no-reply_rmPortal@agsft.com"; String userName = "apikey"; String
	 * password =
	 * "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";
	 * 
	 * @Autowired User user;
	 * 
	 * @SneakyThrows public void sendingEmail() { String finalSubject =
	 * "Activation Link for Recruitment Management Portal - ";
	 * 
	 * // get properties object Properties properties = System.getProperties();
	 * properties.put("mail.transport.protocol", "smtp");
	 * properties.put("mail.smtp.host", "smtp.sendgrid.net");
	 * properties.put("mail.smtp.socketFactory.port", "587");
	 * properties.put("mail.smtp.socketFactory.class",
	 * "javax.net.ssl.SSLSocketFactory"); properties.put("mail.smtp.auth",
	 * "true"); properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.smtp.starttls.required", "true");
	 * properties.put("mail.smtp.port", "587");
	 * 
	 * Session session = Session.getDefaultInstance(properties, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(userName,
	 * password); } });
	 * 
	 * // compose message try {
	 * 
	 * String messageBody = "Hi" + user.getFirstname() + ", \n" +
	 * "Welcome to AGSFT Recruitment Management Portal \n Please click on the activation link below to activate your account \n"
	 * ; String link = "http://localhost:8080/activation"; MimeMessage message =
	 * new MimeMessage(session); message.setFrom(new InternetAddress(from));
	 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	 * message.setSubject(finalSubject);
	 * 
	 * // create MimeBodyPart object and set your message text
	 * 
	 * BodyPart bodyText = new MimeBodyPart();
	 * bodyText.setText(messageBody+link);
	 * 
	 * // create MultiPart object and add MimeBodyPart object to this // object
	 * Multipart multipart = new MimeMultipart();
	 * multipart.addBodyPart(bodyText);
	 * 
	 * // set multipart object to message object message.setContent(multipart);
	 * 
	 * // send message Transport.send(message);
	 * 
	 * System.out.println("Email sent to : " + to);
	 * 
	 * } catch (MessagingException e) { System.out.println(e.getMessage()); }
	 */

	// }

}
