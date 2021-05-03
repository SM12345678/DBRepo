package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

}
