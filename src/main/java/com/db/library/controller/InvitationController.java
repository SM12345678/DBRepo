package com.db.library.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Invitation;
import com.db.library.repository.InvitationRepository;


@Controller
public class InvitationController {
	
	@Autowired
	private InvitationRepository invitationRepository;
	
	
	@RequestMapping(value="/invitations",method=RequestMethod.GET)
	public String invitationsList(Model model) {	
		model.addAttribute("invitations", invitationRepository.findAll());
		return "invitations";
		
	}
	
	@RequestMapping(value="/invitations",method=RequestMethod.POST)
	public String invitationsAdd(@RequestParam Integer authorId, @RequestParam Integer eventId, Model model) {	
		Invitation a1 = new Invitation(authorId, eventId);
		invitationRepository.save(a1);
		model.addAttribute("invitations", invitationRepository.findAll());
		return "redirect:/invitations/";
		
	}
	
//	@RequestMapping(value="/invitations/get",method=RequestMethod.GET)
//	public Invitation getInvitationsList(@RequestParam int id) {		
//		return invitationRepository.findOne(id);
//	}
}
