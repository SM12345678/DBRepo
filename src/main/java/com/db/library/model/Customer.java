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
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cus_id")
	private Integer id;	
	

	private String idType;
	
	private String idNumber;
	
	private String fullName;
	
	private long phoneNumber;
	
	private String emailAddress;
	
	 @Column(nullable = false, length = 64)
	 private String password;
	     
	 public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Column(name = "is_admin", nullable = true)
	 private Boolean isAdmin;
	
	public Customer(Integer id, String idType, String idNumber, String fullName, long phoneNumber, String emailAddress,
			String password, Boolean isAdmin) {
		super();
		this.id = id;
		this.idType = idType;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.isAdmin = isAdmin;
	}

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
