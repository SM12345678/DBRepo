package com.db.library.controller;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.db.library.model.Author;
import com.db.library.model.AutoCompleteItem;
import com.db.library.model.Book;
import com.db.library.model.Topic;
import com.db.library.repository.AuthorRepository;
import com.db.library.repository.BookRepository;
import com.db.library.repository.TopicRepository;


@Controller
public class BookController {
	
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String booksList(Model model) {	
		
		List<Book> bookList= bookRepository.findAll();
		List<Topic> topicList= topicRepository.findAll();
		List<Author> authorList= authorRepository.findAll();
		
		
		bookList.forEach(f -> f.setAuthorsString());
		model.addAttribute("books", bookList);
		model.addAttribute("topics", topicList);
		model.addAttribute("authors", authorList);
		
		return "books";
		
	}
	

	@RequestMapping(value="/books/add",method=RequestMethod.GET)
	public ModelAndView addBook(Model model) {	
		
		Book bookObj=new Book();
		
		List<Topic> topicList= topicRepository.findAll();
		List<Author> authorList= authorRepository.findAll();
		authorList.forEach(f -> f.setfullName());
		
		model.addAttribute("book", bookObj);
		model.addAttribute("topics", topicList);
		model.addAttribute("authors", authorList);
		
		return new ModelAndView("addBook");
		
	}
	
	
	  @PostMapping("/books/add")
	  public ModelAndView SaveBook(@ModelAttribute("book") Book book,RedirectAttributes redirectAttributes,@ModelAttribute("id")String id,Model model) {
	  
	  List<Author> authorList= authorRepository.findAllById(book.authorids);
	  Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
	  book.setAuthors(authorSet);
	  
	  book.setTopic(topicRepository.findById(book.topicid).orElse(null));
	  
	  book=bookRepository.save(book); redirectAttributes.addFlashAttribute("id",
	  book.getId()); //return new ModelAndView("redirect:/books/get/");
	  
	  model.addAttribute("book", book); 
	  return new ModelAndView("viewBook");
	  
	  //return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");
	  
	 // return new ModelAndView("redirect:/books/");
	  
	  }
	
	  
	
	@RequestMapping(value="/books/get/",method=RequestMethod.GET)
	public String getBook(
			  @RequestParam(value="id", required = false) String id,Model model) {	
    id=String.valueOf(model.getAttribute("id"));
	Book bookObj=bookRepository.findById(Integer.parseInt(id)).get();
    bookObj.setAuthorsString();
	model.addAttribute("book", bookObj);
		return "viewBook";
	}
	
	@RequestMapping(value="/books/edit",method=RequestMethod.GET)
	public String editBook(
			  @RequestParam(value="id", required = false) String id,Model model) {	
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
   // id=String.valueOf(model.getAttribute("id"));
	Book bookObj=bookRepository.findById(Integer.parseInt(id)).get();
    bookObj.setAuthorsString();
    bookObj.setId(Integer.parseInt(id));
	List<Integer> authorIds = bookObj.getAuthors().stream().map(Author::getAuthorId).collect(Collectors.toList());
	bookObj.authorids=authorIds;
	
	List<Topic> topicList= topicRepository.findAll();
	List<Author> authorList= authorRepository.findAll();
	authorList.forEach(f -> f.setfullName());
	tx.commit();
	model.addAttribute("topics", topicList);
	model.addAttribute("authors", authorList);
	model.addAttribute("book", bookObj);
		return "editBook";
	}
	
	@PostMapping("/books/edit")
	  public ModelAndView updateBook(@ModelAttribute("book") Book book,RedirectAttributes redirectAttributes,@ModelAttribute("id")String id,Model model) {
	  
	 
	  
	  book.setTopic(topicRepository.findById(book.topicid).orElse(null));
	
		  try(Session sessionnew = sessionFactory.openSession()) {
			  sessionnew.beginTransaction();
			  List<Author> authorList= authorRepository.findAllById(book.authorids);
			  Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
			  book.setAuthors(authorSet);
			  sessionnew.saveOrUpdate(book);
			  sessionnew.getTransaction().commit();
		  }
	
	 
	//  redirectAttributes.addFlashAttribute("id",book.getId()); 
	  model.addAttribute("book", book); 
	  return new ModelAndView("viewBook");
	  
	  //return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");
	  
	 // return new ModelAndView("redirect:/books/");
	  
	  }
	

	@RequestMapping(value = "/books/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Book SaveBook(@RequestBody Book book) {	
	
		List<Author> authorList= authorRepository.findAllById(book.authorids);
		Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
		book.setAuthors(authorSet);
		
		book.setTopic(topicRepository.findById(book.topicid).orElse(null));
		
		book=bookRepository.save(book);
		book.setAuthorsString();
	//    redirectAttributes.addFlashAttribute("id", book.getId());
		//return new ModelAndView("redirect:/books/get/");
		
		return book;
		
		//return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/books",method=RequestMethod.POST)
	public String bookAdd(@RequestParam String bookName, @RequestParam int topicId, 
			@RequestParam List<Integer> author_ids,  Model model) {	
		
		
		   try(Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			
			Book b1 = new Book();
			b1.setBookName(bookName);
			
			Topic t=topicRepository.findById(topicId).get();
			b1.setTopic(t);
			
			
			List<Author> authorList= authorRepository.findAllById(author_ids);
			Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
			b1.setAuthors(authorSet);
			
			bookRepository.save(b1);
			session.getTransaction().commit();
		   }
		
		
		return "redirect:/books/";
		
	}
	
	
	
	
	
	
	
	
	   

	   

	 
	
	

}
