package com.db.library.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sm_events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer eventId;
	private String eventName;
	private Date eventStartDatetime;
	private Date eventStopDatetime;
	//private Integer topicId;
	private Character eventType;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="topic_id", nullable=false)
	private Topic topic;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Seminar seminar;
	
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Exhibition exhibition;
	
	
	

	public Event() {
		
	}
	
	public Event(Integer eventId, String eventName, Date eventStartDateTime, 
			Date eventStopDateTime, Topic topic, Character eventType) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventStartDatetime = eventStartDateTime;
		this.eventStopDatetime = eventStopDateTime;
		this.topic = topic;
		this.eventType = eventType;
	}
	
	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}
	
	public Exhibition getExhibition() {
		return exhibition;
	}

	
	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventStartDatetime() {
		return eventStartDatetime;
	}
	public void setEventStartDatetime(Date eventStartDatetime) {
		this.eventStartDatetime = eventStartDatetime;
	}
	public Date getEventStopDatetime() {
		return eventStopDatetime;
	}
	public void setEventStopDateTime(Date eventStopDatetime) {
		this.eventStopDatetime = eventStopDatetime;
	}

	public char getEventType() {
		return eventType;
	}
	public void setEventType(char eventType) {
		this.eventType = eventType;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
