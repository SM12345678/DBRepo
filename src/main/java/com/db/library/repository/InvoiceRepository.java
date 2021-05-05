package com.db.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.db.library.model.Author;
import com.db.library.model.BookCopy;
import com.db.library.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	

	List<Invoice> findByRentalid(int rentalid);	

}
