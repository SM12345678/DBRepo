package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.db.library.model.Author;
import com.db.library.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	

}
