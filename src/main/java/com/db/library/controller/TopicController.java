package com.db.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Topic;
import com.db.library.repository.TopicRepository;

@Controller
public class TopicController {
	@Autowired
	private TopicRepository topicRepository;
	
	
	@RequestMapping(value="/topics",method=RequestMethod.GET)
	public String TopicList(Model model) {
		model.addAttribute("topics", topicRepository.findAll());
		return "topics";
	}
	
	
//	@RequestMapping(value="/seminars",method=RequestMethod.POST)
//	public String TopicAdd(@RequestParam int eventId, Model model) {
//		Seminar s1 = new Seminar(eventId);
//		seminarRepository.save(s1);
//		model.addAttribute("seminars", topicRepository.findAll());
//		return "redirect:/seminars/";
//	}
}
