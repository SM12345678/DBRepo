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
	
//	@RequestMapping(value="/events/edit",method=RequestMethod.GET)
//	public String eventEdit(@RequestParam int eventId,Model model) {
//		
//		List<Topic> listOfTopics = topicRepository.findAll();
//		model.addAttribute("event", eventService.getEvent(eventId));
//		model.addAttribute("listOfTopics", listOfTopics);
//		return "event_edit";
//	}
//	
//	@RequestMapping(value="/events/delete",method=RequestMethod.GET)
//	public String deleteEvent(@RequestParam int eventId,Model model) {
//		eventService.deleteEvent(eventId);
//		List<Event> listOfEvents = eventService.getAllEvents();
//		List<Topic> listOfTopics = topicRepository.findAll();
//		model.addAttribute("listOfEvents", listOfEvents);
//		model.addAttribute("listOfTopics", listOfTopics);
//		return "redirect:/events/";
//	}
//	
//	
	@RequestMapping(value="/sponsors",method=RequestMethod.POST)
	public String sponsorAdd(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String orgName,@RequestParam String sponsorType,Model model) {
		Sponsor sponsor = new Sponsor();
		sponsor.setSponsorType(sponsorType.charAt(0));
		sponsor = sponsorRepository.save(sponsor);
		if(sponsor.getSponsorType()=='O') {
			orgRepository.save(new Organization(sponsor.getSponsorId(),orgName,sponsor));
			
		} else {
			individualRepository.save(new Individual(sponsor.getSponsorId(),firstName,lastName,sponsor));
		}
		//sponsorRepository.save(sponsor);
		return "redirect:/sponsors/";
	}
//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss", Locale.ENGLISH);
//	@RequestMapping(value="/events/update",method=RequestMethod.POST)
//	public String eventUpdate(@RequestParam Integer eventId,@RequestParam String eventName, @RequestParam String eventStartDatetime, 
//			@RequestParam String eventStopDatetime, @RequestParam int topicId, @RequestParam char eventType,Double expenses,Model model) throws ParseException {
//		Topic tp = topicRepository.getOne(topicId);
//		Event e1 = new Event(eventId, eventName, formatter.parse(eventStartDatetime), formatter.parse(eventStopDatetime), tp, eventType);
//		eventService.createEvent(e1, expenses);
//		model.addAttribute("events", eventService.getAllEvents());
//		model.addAttribute("listOfTopics", topicRepository.findAll());
//		return "redirect:/events/";
//	}
}
