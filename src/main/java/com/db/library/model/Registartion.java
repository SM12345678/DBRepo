package com.db.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sm_registration")
public class Registartion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer registartionId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="topic_id", nullable=false)
	private Topic topic;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=true)
	private Seminar seminar;
}
