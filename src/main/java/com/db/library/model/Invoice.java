package com.db.library.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="sm_invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="invoice_id")
	private Integer invoiceid;	
	
	@Column(name="invoice_date")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date invoicedate;
	

	@Column(name="invoice_amount")
	private Integer invoiceamount;
	
	@Column(name="rental_id")
	private int rentalid;

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public java.util.Date getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(java.util.Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	public Integer getInvoiceamount() {
		return invoiceamount;
	}

	public void setInvoiceamount(Integer invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	public int getRentalid() {
		return rentalid;
	}

	public void setRentalid(int rentalid) {
		this.rentalid = rentalid;
	}

	
	
	
}
