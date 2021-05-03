package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sm_seminar")
public class Seminar {
	@Id
	private int eventId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Event event;
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Seminar() {
		
	}
	
	public Seminar(int eventId) {
		this.eventId = eventId;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
}
