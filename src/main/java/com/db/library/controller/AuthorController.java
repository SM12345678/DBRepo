package com.db.library.controller;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.db.library.model.Author;
import com.db.library.repository.AuthorRepository;

@Controller
public class AuthorController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping(value="/a/authors",method=RequestMethod.GET)
	public String authorsList(Model model) {	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Author> authorList=  authorRepository.findAll();
		tx.commit();
		session.close();
		
		model.addAttribute("authors", authorList);
		return "authors";
		
	}
	
	@RequestMapping(value="/authors",method=RequestMethod.POST)
	public String authorsAdd(@RequestParam(required = false) Integer authorId,@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, 
			@RequestParam String email, @RequestParam String city, @RequestParam String state,
			@RequestParam(required = false) String zipCode, @RequestParam(required = false) String stAddress,  Model model) {	
		Author a1 = new Author(authorId,firstName, lastName, stAddress, city, state, zipCode, email);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		authorRepository.save(a1);
		tx.commit();
		session.close();
		return "redirect:/a/authors/";
		model.addAttribute("authors", authorRepository.findAll());
		return "redirect:/authors/";
		
	}
	
	@RequestMapping(value="/authors/edit",method=RequestMethod.GET)
	public String editAuthorList(@RequestParam int id, Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		model.addAttribute("author", authorRepository.getOne(id));
		tx.commit();
		session.close();
		return "author_edit";
	}
	
	@RequestMapping(value="/authors/delete",method=RequestMethod.GET)
	public String deleteAuthor(@RequestParam int id, Model model) {
	public String deleteAuthor(@RequestParam int id, Model model) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		authorRepository.deleteById(id);
		tx.commit();
		session.close();
		return "redirect:/a/authors/";
		return "redirect:/authors/";
	}
}
