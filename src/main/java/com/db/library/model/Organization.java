package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sm_organization")
public class Organization {
	@Id
	private Integer sponsorId;
	
	private String orgName;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sponsor_id", nullable=true)
	private Sponsor sponsor;
	
	public Organization() {}
	
	

	public Organization(Integer sponsorId, String orgName, Sponsor sponsor) {
		super();
		this.sponsorId = sponsorId;
		this.orgName = orgName;
		this.sponsor = sponsor;
	}



	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
}
