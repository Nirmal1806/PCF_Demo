
package com.electrostop.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.electrostop.contactperson.Contactuser;
import com.electrostop.MailAPI.MailAPI;


@RestController
public class controller {
	
	@Autowired
	private JdbcTemplate jdbc;
	
    @Autowired
	MailAPI mp;
 
    // Used toinsert data into the pcf db.
@RequestMapping("/hello")
public String helo() {
	Date date=java.util.Calendar.getInstance().getTime();  
	System.out.println(date.toString());
	 jdbc.execute("insert into user(name,email,message)values('demo','java@demo.commm','"+date.toString()+"')"); 
		System.out.println("2");
	return "Successfully Entered into db";
}


@RequestMapping("/")
public ModelAndView birthday()//HttpServletRequest req,HttpServletResponse res)
{
	return new ModelAndView("MainPage");
}


@RequestMapping("/details")
public String details(HttpServletRequest  request, HttpServletResponse res) throws Exception
{                            
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String email = request.getParameter("email");
		Contactuser contactuser= new Contactuser(name,message,email);
		
		if(mp.sendMail(contactuser))
		{
		jdbc.execute("insert into user(name,email,message)values('"+""+name+"','"+email+"','"+message+"')");
		return "true";
		}
		else
		{
			System.out.println("error");
			return "false";
		}
}

}
