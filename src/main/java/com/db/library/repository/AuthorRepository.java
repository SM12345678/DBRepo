package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.db.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	

}
