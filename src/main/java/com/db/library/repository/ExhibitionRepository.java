package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Author;
import com.db.library.model.Exhibition;


public interface ExhibitionRepository extends JpaRepository<Exhibition, Integer>{

}
