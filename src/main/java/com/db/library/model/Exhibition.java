package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sm_exhibition")
public class Exhibition {
	
	@Id
	private Integer eventId;
	private Double expenses;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Event event;
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Exhibition() {
		
	}
	
	public Exhibition(Integer eventId, Double expenses) {
		this.eventId = eventId;
		this.expenses = expenses;
	}
	
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Double getExpenses() {
		return expenses;
	}
	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}
	
}
