package com.db.library.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.library.model.Reservation;
import com.db.library.model.Room;
import com.db.library.model.Topic;
import com.db.library.repository.CustomerRepository;
import com.db.library.repository.RegistrationRepository;
import com.db.library.repository.ReservationRepository;
import com.db.library.repository.RoomRepository;
import com.db.library.repository.TopicRepository;


@Controller
public class RoomController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired CustomerRepository customerRepository;
	
	@Autowired RegistrationRepository registrationRepository;
	
	
	@RequestMapping(value="/a/bookRoom",method=RequestMethod.GET)
	public String roomAdd(Model model) {
		List<Room> listofRooms = roomRepository.findAll();
		List<Reservation> listofReservation=reservationRepository.findAll();

		/*
		 * for(Room room:listofRooms) { List<Reservation> listofRoomReservation =
		 * listofReservation.stream().filter(c ->
		 * c.getRoom().getRoomId()==room.getRoomId()&&c.getReservationdate()==LocalDate.
		 * now()) .collect(Collectors.toList());
		 * 
		 * listofRoomReservation. }
		 */
		
		
		model.addAttribute("listOfRooms", listofRooms);
		return "bookRoom";
	}
	@RequestMapping(value="/a/bookRoom",method=RequestMethod.POST)
	public String roomAdd(@RequestParam String rcapacity,Double expenses,Model model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Room r=new Room();
		r.setRoomCapacity(Integer.parseInt(rcapacity));
	    r = roomRepository.save(r);	
		tx.commit();
		session.close();
		model.addAttribute("listOfRooms", roomRepository.findAll());
		return "redirect:/a/bookRoom/";
	}
	
	@RequestMapping(value="/a/room/makereservation",method=RequestMethod.GET)
	public String reservation(Model model,@RequestParam Integer roomId,@RequestParam String bookingdate, @RequestParam String bookingslot,Principal p) throws ParseException {
		//List<Room> listofRooms = roomRepository.findAll();
		int customerId = customerRepository.findByEmailAddress(p.getName()).getId();
		Reservation r=new Reservation();
		r.setCusid(customerId);
		
	///	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
		//SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);

		//String dateInString = bookingdate;
	//	Date date = formatter.parse(dateInString);
		
		    Date date= DateUtils.parseDate(bookingdate, new String[]{"yyyy-mm-dd"});
		    Date timefrom=date;
			Date timeto=date;
			
		
        r.setRoomid(roomId);
		r.setReservationdate(date);
		

		   
		switch(bookingslot)
		{
		  case "1":
			  timefrom=DateUtils.setHours(timefrom, 8);
			  timeto=DateUtils.setHours(timeto, 10);
		    break;
		  case "2":

			  timefrom=DateUtils.setHours(timefrom, 11);
			  timeto=DateUtils.setHours(timeto, 13);
		    break;
		  case "3":
			  timefrom=DateUtils.setHours(timefrom, 13);
			  timeto=DateUtils.setHours(timeto, 15);
			    // code block
			    break;
		  case "4":
			  timefrom=DateUtils.setHours(timefrom, 16);
			  timeto=DateUtils.setHours(timeto, 18);
			    // code block
			    break;
		  default:
		    // code block
		}
		timeto=DateUtils.setMinutes(timeto, 0);
		timefrom=DateUtils.setMinutes(timefrom, 0);
		r.setTimefrom(timefrom);
		r.setTimeto(timeto);
		System.out.println(date.toString());
		System.out.println(timefrom.toString());
		System.out.println(timeto.toString());
		reservationRepository.save(r);

		//model.addAttribute("listOfRooms", listofRooms);
		return "bookRoom";
	}
}
