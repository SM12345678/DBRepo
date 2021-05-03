package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Individual;

public interface IndividualRepository extends JpaRepository<Individual, Integer>{

}
