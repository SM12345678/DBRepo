package com.db.library.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Customer;
import com.db.library.repository.CustomerRepository;
import com.db.library.service.EmailServiceImpl;

import net.bytebuddy.utility.RandomString;

@Controller
public class IndexController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerRepository customerRepository;
	

	@RequestMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
	
	@RequestMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new Customer());
	     
	    return "user_register";
	}
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public String processRegister(Customer user,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    customerRepository.save(user);
	    tx.commit();
	    session.close();
	    model.addAttribute("Message", "Registered!");
	    model.addAttribute("user", new Customer());
	    return "user_register";
	}
	
	 @Autowired
	    private EmailServiceImpl emailService;
	    
	 
	 @RequestMapping(value = "/sendmail")
	    public String sendmail(Principal p) {


	        return "reset_password_form";
	    }

		@RequestMapping(value="/sendmailtoUser",method=RequestMethod.POST)
	    public String sendmailPost(HttpServletRequest request,Model model) {

	    	//String emailId=p.getName();
			   String custemailId = request.getParameter("custemailId");
	    	  Customer customer = customerRepository.findByEmailAddress(custemailId);
	    	  String token = RandomString.make(30);
	    	  customer.setResetPasswordToken(token);
	    	  customerRepository.save(customer);
	    	  String resetPasswordLink ="http://localhost:8080/reset_password?token=" + token; 
	    	  
	    	   String subject = "Here's the link to reset your password";
	    	     
	    	    String content = "<p>Hello,</p>"
	    	            + "<p>You have requested to reset your password.</p>"
	    	            + "<p>Click the link below to change your password:</p>"
	    	            + "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"
	    	            + "<br>"
	    	            + "<p>Ignore this email if you do remember your password, "
	    	            + "or you have not made the request.</p>";
	    	  
	    	    model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
	    	  
	    	  emailService.sendMail(custemailId, subject, content);
	       

	          return "reset_password_form";
	    }
	    
	    
	    @GetMapping("/reset_password")
	    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
	        Customer customer = customerRepository.getByResetPasswordToken(token);
	        model.addAttribute("token", token);
	         
	        if (customer == null) {
	            model.addAttribute("message", "Invalid Token");
	            return "message";
	        }
	        return "resetpassword";
	    }
	    @PostMapping("/reset_password")
	    public String processResetPassword(HttpServletRequest request, Model model) {
	        String token = request.getParameter("token");
	        String password = request.getParameter("password");
	         
	        Customer customer = customerRepository.getByResetPasswordToken(token);
	        model.addAttribute("title", "Reset your password");
	         
	        if (customer == null) {
	            model.addAttribute("message", "Invalid Token");
	            return "message";
	        } else {
	        	
	        	
	        	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     	    String encodedPassword = passwordEncoder.encode(password);
	        	
	        	customer.setPassword(encodedPassword);
	        	customerRepository.save(customer);
	             
	            model.addAttribute("message", "You have successfully changed your password.");
	            
	        }
	         
	        return "resetPassword";
	    }

}
