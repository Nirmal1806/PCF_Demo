package com.electrostop.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.electrostop.MailAPI.MailAPI;
import com.sendgrid.SendGrid;

@Configuration
public class MailBean {
	//@Value("${sendgrid.api.key}") String sendGridAPIKey;
	
	/*
	 * @Bean public MailAPI beanfunction() { return new MailAPI(); }
	 */
	
	/*
	 * @Bean public SendGrid sendgrid() {
	 * 
	 * return new SendGrid(sendGridAPIKey); }
	 */

}
