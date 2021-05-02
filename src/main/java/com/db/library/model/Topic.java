package com.db.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_topics")
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Topic() {
		// TODO Auto-generated constructor stub
	}
	public Topic(String topicName) {
		// TODO Auto-generated constructor stub
		this.topicName=topicName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topic_id")
	private int id;
	
	@Column(name="topic_name")
	private String topicName;

	public int getId() {
		return id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
