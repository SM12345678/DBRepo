package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Seminar;

public interface SeminarRepository extends JpaRepository<Seminar, Integer>{
	
}
