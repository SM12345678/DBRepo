package com.db.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Seminar;
import com.db.library.model.SeminarSponsor;
import com.db.library.model.SeminarSponsorId;
import com.db.library.model.Sponsor;
import com.db.library.repository.SeminarRepository;
import com.db.library.repository.SeminarSponsorRepository;
import com.db.library.repository.SponsorRepository;

@Controller
public class SeminarController {
	
	@Autowired
	private SeminarRepository seminarRepository;
	
	@Autowired SponsorRepository sponsorRepository;
	
	@Autowired
	SeminarSponsorRepository seminarSponsorRepository;
	
	
	
	@RequestMapping(value="/seminars",method=RequestMethod.GET)
	public String seminarList(Model model) {
		model.addAttribute("listOfSeminars", seminarRepository.findAll());
		model.addAttribute("listOfSponsors", sponsorRepository.findAll());
		return "seminars";
	}
	
	
	@RequestMapping(value="/seminars/addSponsor",method=RequestMethod.POST)
	public String seminarSponsorAdd(@RequestParam Integer eventId, @RequestParam Integer sponsorId, @RequestParam Long amount,Model model) {
		
		SeminarSponsorId ssId = new SeminarSponsorId(eventId, sponsorId);
		SeminarSponsor seminarSponsor = new SeminarSponsor(ssId,seminarRepository.getOne(eventId),sponsorRepository.getOne(sponsorId),amount);
		seminarSponsorRepository.save(seminarSponsor);
		return "redirect:/seminars/";
	}
	
	@RequestMapping(value="/seminars/removesponsor",method=RequestMethod.GET)
	public String seminarSponsorAdd(@RequestParam Integer eventId, @RequestParam Integer sponsorId,Model model) {
		
		SeminarSponsorId ssId = new SeminarSponsorId(eventId, sponsorId);		
		seminarSponsorRepository.deleteById(ssId);
		return "redirect:/seminars/";
	}
}
