package com.db.library.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;

@Entity
@Table(name="sm_book_copy")
public class BookCopy implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="copy_id")
	private int copyid;
	
	@Column(name="book_id")
	private int bookid;
	
	@Column(name="deleted")
	private int deleted;
	
	
	public BookCopy() {
		
	}
	
	public BookCopy(int copyid, int bookid, int deleted) {
		this.copyid = copyid;
		this.bookid = bookid;
		this.deleted = deleted;
	}

	
	public int getCopyid() {
		return copyid;
	}
	
	public void setCopyid(int copyid) {
		this.copyid = copyid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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
