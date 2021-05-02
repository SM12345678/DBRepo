package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.db.library.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{
	
	

}
