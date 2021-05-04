package com.db.library.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Author;
import com.db.library.model.Customer;
import com.db.library.model.Exhibition;
import com.db.library.model.Invitation;
import com.db.library.model.Registration;
import com.db.library.model.Seminar;
import com.db.library.repository.AuthorRepository;
import com.db.library.repository.InvitationRepository;
import com.db.library.repository.SeminarRepository;


@Controller
public class InvitationController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private InvitationRepository invitationRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private SeminarRepository seminarRepository;
	
	
	@RequestMapping(value="/a/invitations",method=RequestMethod.GET)
	public String invitationsList(Model model) {	
		model.addAttribute("listOfInvitations", invitationRepository.findAll());
		model.addAttribute("listOfAuthors", authorRepository.findAll());
		model.addAttribute("listOfSeminars", seminarRepository.findAll());
		return "invitations";
		
	}
	
	@RequestMapping(value="/invitations",method=RequestMethod.POST)
	public String invitationsAdd(@RequestParam Integer authorId, @RequestParam Integer eventId, Model model) {
		
		
		Invitation a1 = new Invitation(null,seminarRepository.getOne(eventId), authorRepository.getOne(authorId));
		invitationRepository.save(a1);
		model.addAttribute("invitations", invitationRepository.findAll());
		return "redirect:/a/invitations/";
		
	}
	
	@RequestMapping(value="/invitations/delete",method=RequestMethod.GET)
	public String deleteInvitation(@RequestParam int id,Model model) {
		invitationRepository.deleteById(id);		
		return "redirect:/a/invitations/";
	}
	
	@RequestMapping(value="/invitations/update",method=RequestMethod.POST)
	public String registrationAdd(@RequestParam int id,@RequestParam Integer authorId, @RequestParam Integer eventId ,Model model) {
		Seminar s = seminarRepository.getOne(eventId);
		Author a = authorRepository.getOne(authorId);
		Invitation inv = new Invitation(id,s,a );
		invitationRepository.save(inv);
		return "redirect:/a/invitations";
	}
	
	@RequestMapping(value="/invitations/edit",method=RequestMethod.GET)
	public String eventEdit(@RequestParam int id,Model model) {	
		
		model.addAttribute("invitation", invitationRepository.getOne(id));
		model.addAttribute("listOfAuthors", authorRepository.findAll());
		model.addAttribute("listOfSeminars", seminarRepository.findAll());
		return "invitation_edit";
	}
}
