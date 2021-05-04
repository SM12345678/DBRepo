package com.db.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.db.library.model.User;
import com.db.library.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
	
	@RequestMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "user_register";
	}
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public String processRegister(User user,Model model) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    userRepository.save(user);
	    model.addAttribute("Message", "Registered!");
	    model.addAttribute("user", new User());
	    return "user_register";
	}
}
