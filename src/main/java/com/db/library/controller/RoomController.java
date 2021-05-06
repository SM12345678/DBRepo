package com.db.library.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@RequestMapping(value="/a/bookRoom/reservation",method=RequestMethod.GET)
	public String reservation(Model model) {
		List<Room> listofRooms = roomRepository.findAll();
		
		model.addAttribute("listOfRooms", listofRooms);
		return "bookRoom";
	}
}
