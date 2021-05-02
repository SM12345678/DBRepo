package com.db.library.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.library.model.Author;
import com.db.library.repository.AuthorRepository;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping(value="/authors",method=RequestMethod.GET)
	public String authorsList(Model model) {	
		List<Author> authorList=  authorRepository.findAll();
		model.addAttribute("authors", authorList);
		return "authors";
		
	}
	
//	@RequestMapping(value="/authors_d",method=RequestMethod.GET)
//	public String authorsD(Model model) {	
//		model.addAttribute("dummy_name", "dummy auth name");
//		return "author_dummy";
//		
//	}
	
	@RequestMapping(value="/authors",method=RequestMethod.POST)
	public String authorsAdd(@RequestParam String firstName, @RequestParam String lastName, 
			@RequestParam String email, @RequestParam String city, @RequestParam String state,
			@RequestParam String zipCode, @RequestParam String stAddress,  Model model) {	
		Author a1 = new Author(firstName, lastName, stAddress, city, state, zipCode, email);
		authorRepository.save(a1);
		model.addAttribute("authors", authorRepository.findAll());
		return "redirect:/authors/";
		
	}
	
	@RequestMapping(value="/authors/get",method=RequestMethod.GET)
	public Author getAuthorList(@RequestParam int id) {		
		return authorRepository.findById(id).get();
	}
}
