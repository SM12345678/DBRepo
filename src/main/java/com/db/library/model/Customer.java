package com.db.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sm_customers")
public class Customer {
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 *  cus_id         BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'This is customer id',
    id_type        VARCHAR(30) NOT NULL COMMENT 'This is customer id type',
    id_number      VARCHAR(30) NOT NULL COMMENT 'Identification number of a given ID type',
    full_name      VARCHAR(30) NOT NULL COMMENT 'This customer full name.',
    phone_number   BIGINT NOT NULL COMMENT 'This is customer phone number.',
    email_address  VARCHAR(100) NOT NULL COMMENT 'This is customer email address.'
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cus_id")
	private Integer id;	
	

	private String idType;
	
	private String idNumber;
	
	private String fullName;
	
	private long phoneNumber;
	
	private String emailAddress;
	
	public Customer(Integer id, String idType, String idNumber, String fullName, long phoneNumber,
			String emailAddress) {
		super();
		this.id = id;
		this.idType = idType;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
