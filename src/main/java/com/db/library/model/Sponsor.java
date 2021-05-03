package com.db.library.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sm_sponsors")
public class Sponsor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer sponsorId;
	


	private Character sponsorType;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sponsor_id", nullable=true)
	private Individual individual;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sponsor_id", nullable=true)
	private Organization organization;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="sponsor_id", nullable=true,referencedColumnName = "sponsorId")
    private Set<SeminarSponsor> seminarSponsors = new HashSet<>();
	
	public Set<SeminarSponsor> getSeminarSponsors() {
		return seminarSponsors;
	}

	public void setSeminarSponsors(Set<SeminarSponsor> seminarSponsors) {
		this.seminarSponsors = seminarSponsors;
	}
	
	public Sponsor() {
		// TODO Auto-generated constructor stub
	}	
	
	public Sponsor(Integer sponsorId, Character sponsorType, Individual individual, Organization organization) {
		super();
		this.sponsorId = sponsorId;
		this.sponsorType = sponsorType;
		this.individual = individual;
		this.organization = organization;
	}
	
	

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Character getSponsorType() {
		return sponsorType;
	}

	public void setSponsorType(Character sponsorType) {
		this.sponsorType = sponsorType;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
