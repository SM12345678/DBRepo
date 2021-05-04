package com.db.library.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Event;
import com.db.library.model.Topic;
import com.db.library.repository.EventRepository;
import com.db.library.repository.TopicRepository;
import com.db.library.service.EventService;

@Controller
public class EventController {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EventService eventService;
	@Autowired
	private TopicRepository topicRepository;
	
	
	@RequestMapping(value="/a/events",method=RequestMethod.GET)
	public String eventList(Model model) {
		List<Event> listOfEvents = eventService.getAllEvents();
		List<Topic> listOfTopics = topicRepository.findAll();
		model.addAttribute("listOfEvents", listOfEvents);
		model.addAttribute("listOfTopics", listOfTopics);
		return "events";
	}
	
	@RequestMapping(value="/events/edit",method=RequestMethod.GET)
	public String eventEdit(@RequestParam int eventId,Model model) {
		
		List<Topic> listOfTopics = topicRepository.findAll();
		model.addAttribute("event", eventService.getEvent(eventId));
		model.addAttribute("listOfTopics", listOfTopics);
		return "event_edit";
	}
	
	@RequestMapping(value="/events/delete",method=RequestMethod.GET)
	public String deleteEvent(@RequestParam int eventId,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		eventService.deleteEvent(eventId);
		tx.commit();
		session.close();
		List<Event> listOfEvents = eventService.getAllEvents();
		List<Topic> listOfTopics = topicRepository.findAll();
		model.addAttribute("listOfEvents", listOfEvents);
		model.addAttribute("listOfTopics", listOfTopics);
		return "redirect:/a/events/";
	}
	
	
	@RequestMapping(value="/events",method=RequestMethod.POST)
	public String eventAdd(@RequestParam String eventName, @RequestParam Date eventStartDatetime, 
			@RequestParam Date eventStopDatetime, @RequestParam int topicId, @RequestParam char eventType,Double expenses,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Topic tp = topicRepository.getOne(topicId);
		Event e1 = new Event(null, eventName, eventStartDatetime, eventStopDatetime, tp, eventType);
		eventService.createEvent(e1, expenses);
		tx.commit();
		session.close();
		model.addAttribute("events", eventService.getAllEvents());
		model.addAttribute("listOfTopics", topicRepository.findAll());
		return "redirect:/a/events/";
	}
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss", Locale.ENGLISH);
	@RequestMapping(value="/events/update",method=RequestMethod.POST)
	public String eventUpdate(@RequestParam Integer eventId,@RequestParam String eventName, @RequestParam String eventStartDatetime, 
			@RequestParam String eventStopDatetime, @RequestParam int topicId, @RequestParam char eventType,Double expenses,Model model) throws ParseException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Topic tp = topicRepository.getOne(topicId);
		Event e1 = eventService.getEvent(eventId);
		e1.setEventName(eventName);
		e1.setEventStartDatetime( formatter.parse(eventStartDatetime));
		e1.setEventStopDateTime(formatter.parse(eventStopDatetime)); 
		e1.setTopic(tp);
		if(e1.getExhibition()!=null)
			e1.getExhibition().setExpenses(expenses);
		eventService.saveEvent(e1);
		tx.commit();
		session.close();
		model.addAttribute("events", eventService.getAllEvents());
		model.addAttribute("listOfTopics", topicRepository.findAll());
		return "redirect:/a/events/";
	}
	
}
