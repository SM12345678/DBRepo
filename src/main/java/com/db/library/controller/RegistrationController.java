package com.db.library.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Customer;
import com.db.library.model.Event;
import com.db.library.model.Exhibition;
import com.db.library.model.Registration;
import com.db.library.model.Topic;
import com.db.library.repository.CustomerRepository;
import com.db.library.repository.ExhibitionRepository;
import com.db.library.repository.RegistrationRepository;
import com.db.library.service.EmailServiceImpl;
import com.db.library.service.EventService;

@Controller
public class RegistrationController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	ExhibitionRepository exhibitionRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/a/registrations",method=RequestMethod.GET)
	public String registrationList(Model model) {
		List<Registration> listOfRegistrations = registrationRepository.findAll();
		model.addAttribute("listOfRegistrations", listOfRegistrations);
		model.addAttribute("listOfCustomers", customerRepository.findAll());
		model.addAttribute("listOfExhibitions", exhibitionRepository.findAll());
		return "registrations";
	}
	
	@RequestMapping(value="/registrations",method=RequestMethod.POST)
	public String registrationAdd(@RequestParam Integer cusId, @RequestParam Integer eventId ,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Exhibition e = exhibitionRepository.getOne(eventId);
		Customer c = customerRepository.getOne(cusId);
		Registration reg = new Registration(null, e, c);
		registrationRepository.save(reg);
		tx.commit();
		session.close();
		return "redirect:/a/registrations";
	}
	
	@RequestMapping(value="/registrations/delete",method=RequestMethod.GET)
	public String deleteEvent(@RequestParam int id,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		registrationRepository.deleteById(id);	
		tx.commit();
		session.close();
		return "redirect:/a/registrations/";
	}
	
	@RequestMapping(value="/registrations/update",method=RequestMethod.POST)
	public String registrationAdd(@RequestParam int id,@RequestParam Integer cusId, @RequestParam Integer eventId ,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Exhibition e = exhibitionRepository.getOne(eventId);
		Customer c = customerRepository.getOne(cusId);
		Registration reg = new Registration(id, e, c);
		registrationRepository.save(reg);
		tx.commit();
		session.close();
		return "redirect:/a/registrations";
	}
	
	@RequestMapping(value="/registrations/edit",method=RequestMethod.GET)
	public String eventEdit(@RequestParam int id,Model model) {	
		
		model.addAttribute("registration", registrationRepository.getOne(id));
		model.addAttribute("listOfCustomers", customerRepository.findAll());
		model.addAttribute("listOfExhibitions", exhibitionRepository.findAll());
		return "registration_edit";
	}



   
	
	
}
