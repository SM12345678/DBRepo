package com.db.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.library.model.Event;
import com.db.library.model.Exhibition;
import com.db.library.model.Seminar;
import com.db.library.repository.EventRepository;
import com.db.library.repository.ExhibitionRepository;
import com.db.library.repository.SeminarRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private SeminarRepository seminarRepository;
	@Autowired
	private ExhibitionRepository exhibitionRepository;
	
	@Transactional
	public void createEvent(Event event, Double expenses) {
		Event newEvent = eventRepository.save(event);
		if(newEvent.getEventType()=='S') {
			Seminar newSeminar = new Seminar(newEvent.getEventId());
			seminarRepository.save(newSeminar);
		}else {
			Exhibition newExhibition = new Exhibition(newEvent.getEventId(), expenses);
			exhibitionRepository.save(newExhibition);
		}
	}
	
	@Transactional
	public void deleteEvent(Integer eventId) {
		
		Event newEvent = eventRepository.getOne(eventId);
		if(newEvent.getEventType()=='S'&&newEvent.getSeminar()!=null) {
			seminarRepository.deleteById(eventId);
		}else if(newEvent.getExhibition()!=null) {
			exhibitionRepository.deleteById(eventId);
		}
		eventRepository.deleteById(eventId);
	}
	
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public Event getEvent(Integer eventId) {
		return eventRepository.getOne(eventId);
	}
}
