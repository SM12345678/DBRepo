package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Reservation;
import com.db.library.model.Room;

	public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	}

