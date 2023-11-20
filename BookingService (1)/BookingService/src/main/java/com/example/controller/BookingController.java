package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.exception.TicketIdNotFoundException;

import com.example.models.BookedTickets;
import com.example.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600 ,allowCredentials="true")
@RequestMapping("/TrainBooking")
public class BookingController {
	Logger log = LoggerFactory.getLogger(BookingController.class);
	@Autowired 
	BookingService service;
	@Autowired
	private RestTemplate restTemplate; 
	
	@GetMapping("/findAlltrains")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")

	public List<Object> getsearchdetails() {
	Object[] objects = restTemplate.getForObject("http://TrainSearch/search/findAlltrains", Object[].class);
	return Arrays.asList(objects);
	}
	
	@GetMapping("/findalltickets")
	//@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")

	public List<BookedTickets> showalltickets() {
		log.info("The available tickets are viewed");
		return service.showalltickets();
	}
	
	

	@GetMapping("/findticket/{id}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<BookedTickets> showbyId(@PathVariable("id") String id) throws TicketIdNotFoundException {
		BookedTickets book = service.getbytrainid(id);
		log.info("The ticket " +id+ " is viewed");
		if (book != null)
			return new ResponseEntity<>(book, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@PutMapping("/updateticket/{id}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<BookedTickets> updateTicket(@PathVariable("id") String id, @RequestBody BookedTickets book)
			throws TicketIdNotFoundException {
		BookedTickets s = service.updateTicket(book);
		log.info("Train " +id+ " updated succesfully");
		if (s != null)
			return new ResponseEntity<>(s, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addticket")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<BookedTickets> addTicket(@RequestBody BookedTickets book) throws TicketIdNotFoundException {

		BookedTickets a = service.addTicket(book);
		log.info("Ticket Added Successfully");
		if (a != null)
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/deleteticket/{id}")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<String> deleteTicket(@PathVariable String id) throws TicketIdNotFoundException {
		String a = service.deleteTicket(id);
		log.info("Deleted successfully");
		if (a != null)
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Could not found", HttpStatus.NOT_FOUND);

	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	


