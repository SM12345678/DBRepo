package com.db.library.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="SM_Seminar_Sponsor")
public class SeminarSponsor {
	
	@EmbeddedId
    private SeminarSponsorId id = new SeminarSponsorId(); 
   
	@ManyToOne
    @MapsId("eventId")
	@JoinColumn(name = "event_id", nullable=true)
    private Seminar seminar;
 
    @ManyToOne
    @MapsId("sponsorId")
    @JoinColumn(name = "sponsor_id", nullable=true)
    private Sponsor sponsor;
 
    private Long amount;
    
    public SeminarSponsor() {}
    
    public SeminarSponsor(SeminarSponsorId id, Seminar seminar, Sponsor sponsor, Long amount) {
		super();
		this.id = id;
		this.seminar = seminar;
		this.sponsor = sponsor;
		this.amount = amount;
	}

	public SeminarSponsorId getId() {
		return id;
	}

	public void setId(SeminarSponsorId id) {
		this.id = id;
	}

	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}


}
