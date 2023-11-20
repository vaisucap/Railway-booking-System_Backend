package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.exception.AmountNotFoundException;
import com.example.exception.TrainIdNotFoundException;
import com.example.models.Fare;
import com.example.service.FareService;

@RestController
@RequestMapping("/Fare")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600 ,allowCredentials="true")
public class FareController {
	Logger log = LoggerFactory.getLogger(FareController.class);
	
	
	
	@Autowired 
	FareService service;
	
	
	



	@GetMapping("/findalltrainsfare")
	//@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")

	public List<Fare> showalltrainsfare() {
		 log.info("Showing All Train's Fare");
		return service.showalltrainsfare();
	}
	
	

	@GetMapping("/findfare/{id}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Fare> showbyId(@PathVariable("id") String id) throws TrainIdNotFoundException {
		Fare fare = service.getfarebytrainid(id);
	     log.info("Fare for train"+id+"is found");
		if (fare != null)
			return new ResponseEntity<>(fare, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@PutMapping("/updatefare/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Fare> updateTicket(@PathVariable("id") String id, @RequestBody Fare fare)
			throws TrainIdNotFoundException {
		Fare s = service.updateFare(fare);
		log.info("Fare for train "+id+" updated successfully");
		if (s != null)
			return new ResponseEntity<>(s, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addfare")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Fare> addTicket(@RequestBody Fare fare) throws TrainIdNotFoundException {

		Fare a = service.addFare(fare);
		  log.info("New Fare for new train added successfully");

		if (a != null)
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/deletefare/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteTicket(@PathVariable String id) throws TrainIdNotFoundException {
		String a = service.deleteFare(id);
		  log.info("Fare for train "+id+" deleted successfully");
		if (a != null)
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Could not found", HttpStatus.NOT_FOUND);

	}
	@GetMapping("/gettrainbyamount/{amount}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Fare> showbyamount(@PathVariable String amount)throws AmountNotFoundException{
		Fare f = service.gettrainbyamount(amount);
	    log.info("Train for fare"+amount+"is found");
		if (f != null)
			return new ResponseEntity<>(f, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

}

	


