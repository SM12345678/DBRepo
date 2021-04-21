package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@ControllerAdvice
public class GreetingController {
	@Autowired
	  private ContactRepository contactRepository;

	//@RequestMapping("/greeting") 
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
//	
//	@RequestMapping(value = "/list_contact", method = RequestMethod.GET)
//	    public ModelAndView listContact(Model model) {  
//		ContactBusiness business=new ContactBusiness();
//	    List<contact> contactList = business.getContactList();
//	         
//	     
//	        ModelAndView modelAndView = new ModelAndView();
//	        modelAndView.setViewName("contact");
//	        modelAndView.addObject("contacts", contactList);  
//	         
//	        return modelAndView;
//	    }

	
	/*
	 * @GetMapping("/list_contact") public String listStudent(Model model) { Contact
	 * business=new Contact(); model.addAttribute("contacts",
	 * business.getContactList()); return "contact"; }
	 */
	
	Session sessionOne = HibernateUtil.getSessionFactory().openSession();
    sessionOne.beginTransaction();
	@GetMapping("/list_contact")
	public String listStudent(Model model) {
	//  Contact business=new Contact();
	  // model.addAttribute("contacts",  contactRepository.findAll());
	 contact c=new contact("Marry John", "marry.john@gmail.com", "USA");
	  contactRepository.save(c);
	    return "contact";
	}

}