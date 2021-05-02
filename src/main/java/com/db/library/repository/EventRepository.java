package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
