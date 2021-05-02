package com.db.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Seminar;
import com.db.library.repository.SeminarRepository;

@Controller
public class SeminarController {
	
	@Autowired
	private SeminarRepository seminarRepository;
	
	
	@RequestMapping(value="/seminars",method=RequestMethod.GET)
	public String SeminarList(Model model) {
		model.addAttribute("seminars", seminarRepository.findAll());
		return "seminars";
	}
	
	
	@RequestMapping(value="/seminars",method=RequestMethod.POST)
	public String SeminarList(@RequestParam int eventId, Model model) {
		Seminar s1 = new Seminar(eventId);
		seminarRepository.save(s1);
		model.addAttribute("seminars", seminarRepository.findAll());
		return "redirect:/seminars/";
	}
}
