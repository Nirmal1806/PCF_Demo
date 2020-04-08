package com.electrostop.MailAPI;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.electrostop.contactperson.Contactuser;
import com.sendgrid.*;

@Service
public class MailAPI {

	@Autowired
	private JavaMailSender sender;
	// @Autowired
	// private SendGrid sendGridClient;

	public boolean sendMail(Contactuser cu) throws Exception {

		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(cu.getEmail());
			helper.setText("Hi " + cu.getName() + "," + "\r\n" + "         "
					+ "Thank you for chosing ElectroStop our technician will be contacting you shortly." + "\r\n"
					+ "\r\n" + "Thank you!!!");
			sender.send(message);
			MimeMessageHelper helper1 = new MimeMessageHelper(message);
			helper1.setTo("mopunimi@gmail.com");
			helper1.setText("From :" + cu.getName() + "\r\n" + "     " + cu.getMessage());
			sender.send(message);

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		/*
		 * Email from = new Email("mopunimi@gmail.com"); String subject =
		 * "Sending with SendGrid is Fun"; Email to = new
		 * Email("nirmallamrin2k17@gmail.com"); Content content = new
		 * Content("text/plain", "and easy to do anywhere, even with Java"); Mail mail =
		 * new Mail(from, subject, to, content);
		 * 
		 * SendGrid sg = new SendGrid(
		 * "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");
		 * Request request = new Request(); try { request.setMethod(Method.POST);
		 * request.setEndpoint("mail/send"); request.setBody(mail.build()); Response
		 * response = sg.api(request); System.out.println(response.getStatusCode());
		 * System.out.println(response.getBody());
		 * System.out.println(response.getHeaders()); return true; } catch (IOException
		 * ex) { System.out.println(ex); return false;
		 * 
		 * }
		 */

	}

}
