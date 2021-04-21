package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
public class contact {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	 public Integer getId() {
		    return id;
		  }
	 public void setId(Integer id) {
		    this.id = id;
		  }
    public String name;
    public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
    public String email;
    public String getEmail() {
        return email;
      }

      public void setEmail(String email) {
        this.email = email;
      }
    public String country;
    public String getCountry() {
        return email;
      }

      public void setCountry(String country) {
        this.country = country;
      }
 
    public contact() {
        super();
    }
 
    public contact(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
    
    
	/*
	 * @Autowired
	 * 
	 * @Qualifier("contactDAO") ContactDAO contactDAO;
	 * 
	 * 
	 * public List<contact> getContactList() { List<contact> listContact = new
	 * ArrayList<>();
	 * 
	 * listContact.add(new contact("Marry John", "marry.john@gmail.com", "USA"));
	 * listContact.add(new contact("Tom Smith", "tomsmith@outlook.com", "England"));
	 * listContact.add(new contact("John Purcell", "john123@yahoo.com",
	 * "Australia")); listContact.add(new contact("Siva Krishna",
	 * "sivakrishna@gmail.com", "India"));
	 * 
	 * List<contact> listContact1= contactDAO.list(); // return listContact; return
	 * listContact1 ;
	 * 
	 * 
	 * }
	 */
    // getters and setters are excluded for brevity
 
}