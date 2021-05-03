package com.db.library.model;

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
@Table(name = "sm_registration")
public class Registration {
	
	public Registration() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer registrationId;
	
	
	

	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="event_id", nullable=true)
	private Exhibition exhibition;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="cus_id", nullable=false)
	private Customer customer;
	
	public Registration(Integer registrationId, Exhibition exhibition, Customer customer) {
		super();
		this.registrationId = registrationId;
		this.exhibition = exhibition;
		this.customer = customer;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}
	
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public Exhibition getExhibition() {
		return exhibition;
	}

	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
