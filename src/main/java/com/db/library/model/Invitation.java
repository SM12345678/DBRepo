package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sm_invitation")
public class Invitation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer invitationId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="event_id", nullable=true)
	private Seminar seminar;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="author_id", nullable=false)
	private Author author;
	
	public Invitation() {
		
	}
	
	
	

	public Invitation(Integer invitationId, Seminar seminar, Author author) {
		super();
		this.invitationId = invitationId;
		this.seminar = seminar;
		this.author = author;
	}




	public Seminar getSeminar() {
		return seminar;
	}



	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}



	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}


	public Integer getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Integer invitationId) {
		this.invitationId = invitationId;
	}



}
