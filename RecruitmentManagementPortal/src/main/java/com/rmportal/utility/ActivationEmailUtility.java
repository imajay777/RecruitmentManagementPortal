package com.rmportal.utility;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;

import com.rmportal.requestModel.RegisterRequestModel;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

/**
 * @author saurabh
 *
 */
@UtilityClass
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActivationEmailUtility {

	String to = "jsourabh@agsft.com";
	String from = "no-reply_rmPortal@agsft.com";
	String userName = "apikey";
	String password = "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";

	@Autowired
	RegisterRequestModel registerRequestModel;

	@SneakyThrows
	public void sendingEmail(String subject) {
		String finalSubject = "Activation Link for Recruitment Management Portal - " + subject;

		// get properties object
		Properties properties = System.getProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.sendgrid.net");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		// compose message
		try {

			String messageBody = "Hi" + registerRequestModel.getFirstname() + ", \n"
					+ "Welcome to AGSFT Recruitment Management Portal \n Please click on the activation link below to activate your account \n";
			String link = "http://localhost:8080/activation";
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(finalSubject);

			// create MimeBodyPart object and set your message text

			BodyPart bodyText = new MimeBodyPart();
			bodyText.setText(messageBody);

			// create MultiPart object and add MimeBodyPart object to this
			// object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyText);

			// set multipart object to message object
			message.setContent(multipart);

			// send message
			Transport.send(message);

			System.out.println("Email sent to : " + to);

		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}

	}

}
