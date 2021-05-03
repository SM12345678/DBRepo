package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
