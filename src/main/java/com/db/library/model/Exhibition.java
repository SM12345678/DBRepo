package com.db.library.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_exhibition")
public class Exhibition {
	
	@Id
	private Integer eventId;
	private Double expenses;
	
	
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
