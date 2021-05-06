package com.db.library.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="sm_study_room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="room_id")
	private Integer roomId;
	
	@Column(name="room_capacity")
	private Integer roomCapacity;

	@Transient
	public List<Integer> availableslots;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public List<Integer> getAvailableslots() {
		return availableslots;
	}
	
	@Transient
	public List<java.util.Date> totallots;


	
	
	
	
}
