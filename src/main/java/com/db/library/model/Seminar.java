package com.db.library.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sm_seminar")
public class Seminar {
	@Id
	private int eventId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Event event;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="event_id", nullable=true,referencedColumnName = "eventId")
    private Set<SeminarSponsor> seminarSponsors = new HashSet<>();
	
	public Set<SeminarSponsor> getSeminarSponsors() {
		return seminarSponsors;
	}

	public void setSeminarSponsors(Set<SeminarSponsor> seminarSponsors) {
		this.seminarSponsors = seminarSponsors;
	}

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
