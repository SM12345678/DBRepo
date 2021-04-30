package com.db.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_exhibition")
public class Exhibition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventId;
	private int expenses;
	
	
	public Exhibition() {
		
	}
	
	public Exhibition(int eventId, int expenses) {
		this.eventId = eventId;
		this.expenses = expenses;
	}
	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	
}
