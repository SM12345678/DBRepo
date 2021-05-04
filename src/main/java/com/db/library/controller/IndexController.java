package com.db.library.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.db.library.model.Customer;
import com.db.library.repository.CustomerRepository;

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
}
