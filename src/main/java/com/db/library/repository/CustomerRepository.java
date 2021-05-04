package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.db.library.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("SELECT u FROM Customer u WHERE u.emailAddress = ?1")
    public Customer findByEmailAddress(String username);
}
