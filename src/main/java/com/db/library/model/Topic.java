package com.db.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sm_topics")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer topicId;
	private String topicName;
	
	public Topic() {
		
	}
	
	public Topic(Integer topicId, String topicName) {
		this.topicId = topicId;
		this.topicName = topicName;
	}	
		
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}	
	
}
