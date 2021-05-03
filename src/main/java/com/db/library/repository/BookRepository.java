package com.db.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByDeleted(int deleted);
	

}
