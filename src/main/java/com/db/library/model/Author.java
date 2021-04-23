package com.db.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_authors")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorId;
	private String firstName;
	private String lastName;
	private String stAddress;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	
	
	public Author() {
		
	}
	
	
	public Author(int authorId, String firstName, String lastName, String stAddress, String city, String state,
			String zipcode, String email) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stAddress = stAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}
	
	public Author(String firstName, String lastName, String stAddress, String city, String state,
			String zipcode, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.stAddress = stAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStAddress() {
		return stAddress;
	}
	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}



