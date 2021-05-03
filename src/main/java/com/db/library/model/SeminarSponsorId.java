package com.db.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SeminarSponsorId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer eventId;
	private Integer sponsorId;
	
	public SeminarSponsorId() {
		
	}
	
	public SeminarSponsorId(Integer eventId, Integer sponsorId) {
		super();
		this.eventId = eventId;
		this.sponsorId = sponsorId;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((sponsorId == null) ? 0 : sponsorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeminarSponsorId other = (SeminarSponsorId) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (sponsorId == null) {
			if (other.sponsorId != null)
				return false;
		} else if (!sponsorId.equals(other.sponsorId))
			return false;
		return true;
	}
	
	
	
}
