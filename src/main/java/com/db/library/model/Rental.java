package com.db.library.model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "SM_Rental")
public class Rental {
	
	public Rental() {
		super();
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="rental_id")
	public int rentalid;
	
	@Column(name="cus_id")
	private Long cusid;
	
	@Column(name="copy_id")
	private int copyid;
	
	@Column(name="borrow_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date borrowdate;
	
	@Column(name="expected_return_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date expectedreturndate;
	
	@Column(name="actual_return_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date actualreturndate;
	

	
		
	public Integer getRentalid() {
		return rentalid;
	}

	public void setRentalid(Integer rentalid) {
		this.rentalid = rentalid;
	}

	public Long getCusid() {
		return cusid;
	}

	public void setCusid(Long cusid) {
		this.cusid = cusid;
	}

	public int getCopyid() {
		return copyid;
	}

	public void setCopyid(int copyid) {
		this.copyid = copyid;
	}

	public java.util.Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(java.util.Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public java.util.Date getExpectedreturndate() {
		return expectedreturndate;
	}

	public void setExpectedreturndate(java.util.Date expectedreturndate) {
		this.expectedreturndate = expectedreturndate;
	}

	public java.util.Date getActualreturndate() {
		return actualreturndate;
	}

	public void setActualreturndate(java.util.Date actualreturndate) {
		this.actualreturndate = actualreturndate;
	}


	@Transient
	public String status;
	
	public String getStatus() {
		return status;
	}

	public void setSatus(String status) {
		this.status = status;
	}
	
	
}
