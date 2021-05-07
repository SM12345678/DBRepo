package com.db.library.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.db.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByDeleted(int deleted);

	Book save(Book book);
	
	@Transactional
	@Modifying
	@Query(value = "CALL SM_PROC_BookName_CHANGE(:bookidparam,:newnameparam);", nativeQuery = true)
	void updateBookNameHistory(@Param("bookidparam") Integer bookidparam,@Param("newnameparam") String newnameparam);
	

}
