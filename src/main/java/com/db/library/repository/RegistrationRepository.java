package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.db.library.model.Customer;
import com.db.library.model.Exhibition;
import com.db.library.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
	
	@Query("SELECT u FROM Registration u WHERE u.customer = ?1 and u.exhibition = ?2")
    public Registration findByCustomerAndExhibition(Customer customer,Exhibition e);

}
