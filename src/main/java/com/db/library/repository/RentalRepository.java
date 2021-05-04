package com.db.library.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.library.model.Author;
import com.db.library.model.Rental;
import com.db.library.model.RentalHistory;

public interface RentalRepository extends JpaRepository<Rental, Integer>{
	
	@Query(value = "CALL sproc_rentalListForCustomer(:custIdparam);", nativeQuery = true)
	List<Tuple> findrentalListForCustomer(@Param("custIdparam") Integer custIdparam);
	
}
