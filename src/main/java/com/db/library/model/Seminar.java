package com.db.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sm_seminar")
public class Seminar {
	@Id
	private int eventId;
	
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
