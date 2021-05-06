package com.db.library.model;


import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="sm_reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="reservation_id")
	private Integer reservationid;
	
	@Column(name="cus_id")
	private Integer cusid;
	

	  @ManyToOne 
	  @JoinColumn(name = "room_id", insertable=false, updatable=false)
	  Room room; 
	  
      public Room getRoom() { return room; }
	  
	  public void setRoom(Room room) { this.room = room; }
	  
	public Integer getRoomid() {
		return room.getRoomId();
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	@Column(name = "room_id")
	private Integer roomid;
	
	@Column(name="reservation_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date reservationdate;
	
	public Integer getReservationid() {
		return reservationid;
	}

	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}

	public Integer getCusid() {
		return cusid;
	}

	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}

	public java.util.Date getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(java.util.Date reservationdate) {
		this.reservationdate = reservationdate;
	}

	public java.util.Date getTimeto() {
		return timeto;
	}

	public void setTimeto(java.util.Date timeto) {
		this.timeto = timeto;
	}

	public java.util.Date getTimefrom() {
		return timefrom;
	}

	public void setTimefrom(java.util.Date timefrom) {
		this.timefrom = timefrom;
	}
	@Column(name="time_to")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timeto;
	
	@Column(name="time_from")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timefrom;
	
	

	 
}
