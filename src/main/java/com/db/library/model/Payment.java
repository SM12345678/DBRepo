package com.db.library.model;

import java.io.Serializable;
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
@Table(name="sm_Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="payment_id")
	private Integer paymentid;	
	
	@Column(name="invoice_id")
	private Integer invoiceid;
	
	@Column(name="payment_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date paymentdate;
	
	@Column(name="card_holder_name")
	private String cardholdername;
	
	@Column(name="payment_amount")
	private Double paymentamount;
	
	@Column(name="payment_method")
	private String paymentmethod;
	

	@Column(name="rental_id")
	private Integer rentalid;
	
	
	public Integer getRentalid() {
		return rentalid;
	}

	public void setRentalid(Integer rentalid) {
		this.rentalid = rentalid;
	}

	@Transient
	public List<String> paymentmethodList;
	
	
	

	public List<String> getPaymentmethodList() {
		return paymentmethodList;
	}

	public void setPaymentmethodList(List<String> paymentmethodList) {
		this.paymentmethodList = paymentmethodList;
	}

	public Integer getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public java.util.Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(java.util.Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getCardholdername() {
		return cardholdername;
	}

	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}

	public Double getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(Double paymentamount) {
		if(paymentamount==0)
		{paymentamount=0.2;}
		
		this.paymentamount = paymentamount;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	
	
	
}
