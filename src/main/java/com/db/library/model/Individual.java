package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sm_individual")
public class Individual {
	@Id
	private Integer sponsorId;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sponsor_id", nullable=true)
	private Sponsor sponsor;
	
	public Individual() {}
	
	public Individual(Integer sponsorId, String firstName, String lastName, Sponsor sponsor) {
		super();
		this.sponsorId = sponsorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sponsor = sponsor;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
	
	
}
