package com.db.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, Integer>{


	List<BookCopy> findByBookidAndDeleted(int bookid,int deleted);	

	
	List<BookCopy> findByDeleted(int deleted);	

}
