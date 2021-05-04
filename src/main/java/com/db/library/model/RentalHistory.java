package com.db.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalHistory {

	public RentalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RentalHistory(int rid, int cusid, int bookid, int bokcopyid, int status, int amountPaid, int amountPending,
			Boolean isamountPending, int status2, String bookName, String authorsString, int copyid) {
		super();
		this.rid = rid;
		this.cusid = cusid;
		this.bookid = bookid;
		this.bokcopyid = bokcopyid;
		Status = status;
		this.amountPaid = amountPaid;
		this.amountPending = amountPending;
		this.isamountPending = isamountPending;
		status = status2;
		this.bookName = bookName;
		this.authorsString = authorsString;
		this.copyid = copyid;
	}

	public int rid;
	public int cusid;
	public int bookid;
	public int bokcopyid;
	public int Status;
	public String StatusText;

	public int amountPaid;
	public int amountPending;
	public Boolean isamountPending;
	public int status;
	public String bookName;
	public String authorsString;
	public int copyid;
	public String topicName;
	
	public String actualreturndate;	
	public String expectedreturndate;
	public String borrowdate;
	

	
	
	
	
	
	

}
