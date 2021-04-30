package com.db.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_invitation")
public class Invitation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int invitationId;
	private int authorId;
	private int eventId;
	
	public Invitation() {
		
	}
	
	public Invitation(int authorId, int eventId) {
		this.authorId = authorId;
		this.eventId = eventId;
	}
	
	public Invitation(int invitationId, int authorId, int eventId) {
		this.invitationId = invitationId;
		this.authorId = authorId;
		this.eventId = eventId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(int invitationId) {
		this.invitationId = invitationId;
	}



}
