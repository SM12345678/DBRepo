package com.db.library.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Sponsor;
import com.db.library.model.Topic;
import com.db.library.repository.TopicRepository;

@Controller
public class TopicController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping(value="/a/topics",method=RequestMethod.GET)
	public String topicList(Model model) {
		model.addAttribute("allTopicsList", topicRepository.findAll());
		return "topics";
	}
	
	
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public String topicAdd(@RequestParam(required = false) Integer topicId, String topicName,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Topic t = new Topic(topicId, topicName);
		topicRepository.save(t);
		tx.commit();
		session.close();
		return "redirect:/a/topics";
	}
	
	@RequestMapping(value="/topics/delete",method=RequestMethod.GET)
	public String deleteTopic(@RequestParam  Integer topicId,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		topicRepository.deleteById(topicId);
		tx.commit();
		session.close();
		return "redirect:/a/topics";
	}
	
	@RequestMapping(value="/topics/edit",method=RequestMethod.GET)
	public String sponsorEdit(@RequestParam Integer topicId,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		model.addAttribute("topic", topicRepository.getOne(topicId));
		tx.commit();
		session.close();
		return "topic_edit";
	}
	
	
}
