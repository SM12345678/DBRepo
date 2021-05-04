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
	

	
	@RequestMapping(value="/authors",method=RequestMethod.POST)
	public String authorsAdd(@RequestParam(required = false) Integer authorId,@RequestParam String firstName, @RequestParam String lastName, 
			@RequestParam String email, @RequestParam String city, @RequestParam String state,
			@RequestParam String zipCode, @RequestParam String stAddress,  Model model) {	
		Author a1 = new Author(authorId,firstName, lastName, stAddress, city, state, zipCode, email);
		authorRepository.save(a1);
		model.addAttribute("authors", authorRepository.findAll());
		return "redirect:/authors/";
		
	}
	
	@RequestMapping(value="/authors/edit",method=RequestMethod.GET)
	public String editAuthorList(@RequestParam int id, Model model) {		
		model.addAttribute("author", authorRepository.getOne(id));
		return "author_edit";
	}
	
	@RequestMapping(value="/authors/delete",method=RequestMethod.GET)
	public String deleteAuthor(@RequestParam int id, Model model) {		
		authorRepository.deleteById(id);
		return "redirect:/authors/";
	}
}
