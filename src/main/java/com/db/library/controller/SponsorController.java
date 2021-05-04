package com.db.library.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Event;
import com.db.library.model.Individual;
import com.db.library.model.Organization;
import com.db.library.model.Sponsor;
import com.db.library.model.Topic;
import com.db.library.repository.IndividualRepository;
import com.db.library.repository.OrgRepository;
import com.db.library.repository.SponsorRepository;

@Controller
public class SponsorController {
	
	@Autowired
	private SponsorRepository sponsorRepository;
	@Autowired
	private IndividualRepository individualRepository;
	@Autowired
	private OrgRepository orgRepository;
	
	@RequestMapping(value="/sponsors",method=RequestMethod.GET)
	public String sponsorList(Model model) {
		
		model.addAttribute("listOfSponsors", sponsorRepository.findAll());
		return "sponsors";
	}
	
	@RequestMapping(value="/sponsors/edit",method=RequestMethod.GET)
	public String sponsorEdit(@RequestParam Integer sponsorId,Model model) {		
		
		model.addAttribute("sponsor", sponsorRepository.getOne(sponsorId));
		return "sponsor_edit";
	}
	
	@RequestMapping(value="/sponsors/delete",method=RequestMethod.GET)
	public String deleteSponsor(@RequestParam  Integer sponsorId,Model model) {
		Sponsor sponsor = sponsorRepository.getOne(sponsorId);
		if(sponsor.getIndividual()!=null) {
			individualRepository.deleteById(sponsorId);
		}
		if(sponsor.getOrganization()!=null) {
			orgRepository.deleteById(sponsorId);
		}
		//sponsorRepository.deleteById(sponsorId);
		return "redirect:/sponsors/";
	}
//	
//	
	@RequestMapping(value="/sponsors",method=RequestMethod.POST)
	public String sponsorAdd(@RequestParam(required = false) Integer sponsorId, @RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,@RequestParam(required = false) String orgName,
			@RequestParam(required = false) String sponsorType,Model model) {
		Sponsor sponsor = new Sponsor();
		sponsor.setSponsorType(sponsorType.charAt(0));
		sponsor.setSponsorId(sponsorId);
		sponsor = sponsorRepository.save(sponsor);
		if(sponsor.getSponsorType()=='O') {
			orgRepository.save(new Organization(sponsor.getSponsorId(),orgName,sponsor));
			
		} else {
			individualRepository.save(new Individual(sponsor.getSponsorId(),firstName,lastName,sponsor));
		}
		return "redirect:/sponsors/";
	}
}
