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
import com.db.library.model.Book;
import com.db.library.model.BookCopy;
import com.db.library.model.Topic;
import com.db.library.repository.AuthorRepository;
import com.db.library.repository.BookCopyRepository;
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
	private BookCopyRepository bookCopyRepository;


	@Autowired
	private AuthorRepository authorRepository;

	@RequestMapping(value = "/a/books", method = RequestMethod.GET)
	public String booksList(Model model) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> bookList = bookRepository.findByDeleted(0);
		List<Topic> topicList = topicRepository.findAll();
		List<Author> authorList = authorRepository.findAll();
		bookList.forEach(f -> f.setAuthorsString());
		tx.commit();
        session.close();
        
        
		model.addAttribute("books", bookList);
		model.addAttribute("topics", topicList);
		model.addAttribute("authors", authorList);

		return "books";

	}

	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
	public ModelAndView addBook(Model model) {

		Book bookObj = new Book();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Topic> topicList = topicRepository.findAll();
		List<Author> authorList = authorRepository.findAll();
		tx.commit();
        session.close();
		
		authorList.forEach(f -> f.setfullName());
		
		model.addAttribute("book", bookObj);
		model.addAttribute("topics", topicList);
		model.addAttribute("authors", authorList);

		return new ModelAndView("addBook");

	}

	@PostMapping("/books/add")
	public ModelAndView SaveBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes,
			@ModelAttribute("id") String id, Model model) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Author> authorList = authorRepository.findAllById(book.authorids);
		Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
		book.setAuthors(authorSet);
		book.setTopic(topicRepository.findById(book.topicid).orElse(null));
		book = bookRepository.save(book);
		tx.commit();
        session.close();
		
		redirectAttributes.addFlashAttribute("id", book.getId()); // return new ModelAndView("redirect:/books/get/");

		model.addAttribute("book", book);
		return new ModelAndView("viewBook");

		// return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");

		// return new ModelAndView("redirect:/books/");

	}

	@RequestMapping(value = "/a/books/get/", method = RequestMethod.GET)
	public String getBook(@RequestParam(value = "id", required = false) String id, Model model) {
		id = String.valueOf(model.getAttribute("id"));
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Book bookObj = bookRepository.findById(Integer.parseInt(id)).get();
		tx.commit();
		session.close();
		
		bookObj.setAuthorsString();
		model.addAttribute("book", bookObj);
		
		return "viewBook";
	}

	@RequestMapping(value = "/books/edit", method = RequestMethod.GET)
	public String editBook(@RequestParam(value = "id", required = false) String id, Model model) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// id=String.valueOf(model.getAttribute("id"));
		Book bookObj = bookRepository.findById(Integer.parseInt(id)).get();
		bookObj.setAuthorsString();
		bookObj.setId(Integer.parseInt(id));
		List<Integer> authorIds = bookObj.getAuthors().stream().map(Author::getAuthorId).collect(Collectors.toList());
		bookObj.authorids = authorIds;
		List<Topic> topicList = topicRepository.findAll();
		List<Author> authorList = authorRepository.findAll();
		authorList.forEach(f -> f.setfullName());
		tx.commit();
		session.close();
		
		model.addAttribute("topics", topicList);
		model.addAttribute("authors", authorList);
		model.addAttribute("book", bookObj);
		return "editBook";
	}

	@PostMapping("/books/edit")
	public ModelAndView updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes,
			@ModelAttribute("id") String id, Model model) {

		book.setTopic(topicRepository.findById(book.topicid).orElse(null));

		try (Session sessionnew = sessionFactory.openSession()) {
			sessionnew.beginTransaction();
			if (book.authorids != null) {
				List<Author> authorList = authorRepository.findAllById(book.authorids);
				Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
				book.setAuthors(authorSet);
			}
			sessionnew.saveOrUpdate(book);
			sessionnew.getTransaction().commit();
		}

		// redirectAttributes.addFlashAttribute("id",book.getId());
		model.addAttribute("book", book);
		return new ModelAndView("viewBook");

		// return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");

		// return new ModelAndView("redirect:/books/");

	}

	@RequestMapping(value = "/books/delete", method = RequestMethod.GET)
	public ModelAndView deleteBook(@RequestParam(value = "id", required = false) String id, Model model) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Book bookObj = bookRepository.findById(Integer.parseInt(id)).get();
		bookObj.setId(Integer.parseInt(id));
		bookObj.setDeleted(1);
		bookRepository.save(bookObj);
		tx.commit();
        session.close();
        
		return new ModelAndView("redirect:/a/books/");

	}

	@RequestMapping(value = "/books/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Book SaveBook(@RequestBody Book book) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		if (book.authorids != null) {
			List<Author> authorList = authorRepository.findAllById(book.authorids);
			Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
			book.setAuthors(authorSet);
		}
		book.setTopic(topicRepository.findById(book.topicid).orElse(null));

		book = bookRepository.save(book);
		tx.commit();
		session.close();
		
		book.setAuthorsString();
		// redirectAttributes.addFlashAttribute("id", book.getId());
		// return new ModelAndView("redirect:/books/get/");

		return book;

		// return new ModelAndView("redirect:/books/get?id={"+book.getId()+"}");

	}
	
	
	
	@RequestMapping(value = "/a/books/copies", method = RequestMethod.GET)
	public String booksCopyList(@RequestParam(value = "id", required = false) String id, Model model) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<BookCopy> bookCopyList=bookCopyRepository.findByBookidAndDeleted(Integer.parseInt(id), 0);
		Book book = bookRepository.findById(Integer.parseInt(id)).get();
		
		tx.commit();
		session.close();
		
		
		String status="Available";
		bookCopyList.forEach(f -> f.status=status);
		
		model.addAttribute("bookCopyList", bookCopyList);
		model.addAttribute("book", book);
		model.addAttribute("NewCopyId", 0);
		
		

		return "bookCopy";

	}
	
	
	@RequestMapping(value = "/books/copy/delete", method = RequestMethod.GET)
	public String deleteBookCopy(@RequestParam(value = "id", required = false) String id, Model model,RedirectAttributes redirectAttributes) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		BookCopy bookCopyObj = bookCopyRepository.findById(Integer.parseInt(id)).get();

		bookCopyObj.setCopyid(Integer.parseInt(id));
		bookCopyObj.setDeleted(1);
		bookCopyRepository.save(bookCopyObj);
     
	
		
		redirectAttributes.addFlashAttribute("id", bookCopyObj.getBookid());
		
        int bookId=bookCopyObj.getBookid();
		List<BookCopy> bookCopyList=bookCopyRepository.findByBookidAndDeleted(bookId, 0);
		Book book = bookRepository.findById(bookId).get();
		
		tx.commit();
		session.close();
		
		String status="Available";
		bookCopyList.forEach(f -> f.status=status);
		
		model.addAttribute("bookCopyList", bookCopyList);
		model.addAttribute("book", book);
		model.addAttribute("NewCopyId", 0);
		

		return "bookCopy";

	}
	
	
	@RequestMapping(value = "/books/copy/add", method = RequestMethod.GET)
	public String addBookCopy(@RequestParam(value = "id", required = false) String id, Model model,RedirectAttributes redirectAttributes) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		BookCopy bookCopyObj =new BookCopy();
		bookCopyObj.setBookid(Integer.parseInt(id));
	    bookCopyRepository.save(bookCopyObj);

		
		redirectAttributes.addFlashAttribute("id", bookCopyObj.getBookid());
		
		
		List<BookCopy> bookCopyList=bookCopyRepository.findByBookidAndDeleted(Integer.parseInt(id), 0);
		Book book = bookRepository.findById(Integer.parseInt(id)).get();
		
		String status="Available";
		bookCopyList.forEach(f -> f.status=status);
		
		tx.commit();
		session.close();
		
		
		model.addAttribute("bookCopyList", bookCopyList);
		model.addAttribute("book", book);
		model.addAttribute("NewCopyId", 0);
		

		return "bookCopy";

	}
	

	
	
	

	/*
	 * @RequestMapping(value = "/books", method = RequestMethod.POST) public String
	 * bookAdd(@RequestParam String bookName, @RequestParam int topicId,
	 * 
	 * @RequestParam List<Integer> author_ids, Model model) {
	 * 
	 * try (Session session = sessionFactory.openSession()) {
	 * session.beginTransaction();
	 * 
	 * Book b1 = new Book(); b1.setBookName(bookName);
	 * 
	 * Topic t = topicRepository.findById(topicId).get(); b1.setTopic(t);
	 * 
	 * List<Author> authorList = authorRepository.findAllById(author_ids);
	 * Set<Author> authorSet = authorList.stream().collect(Collectors.toSet());
	 * b1.setAuthors(authorSet);
	 * 
	 * bookRepository.save(b1); session.getTransaction().commit(); }
	 * 
	 * return "redirect:/books/";
	 * 
	 * }
	 */

}
