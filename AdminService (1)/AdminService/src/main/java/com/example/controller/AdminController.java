package com.example.controller;



	import java.util.Arrays;

import java.util.List;
	
	

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;

	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import com.example.exception.TrainIdNotFoundException;
import com.example.models.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;

	
	@RestController
	@RequestMapping("/Admin")
	public class AdminController {
		
		Logger log = LoggerFactory.getLogger(AdminController.class);
		
			@Autowired
			AdminService service;
			@Autowired
			private RestTemplate restTemplate;
			
			

			  @GetMapping("/adminsearch") public List<Object> getSearch(){ Object[]
			  objects=restTemplate.getForObject("http://TrainSearch/search/findAllTrains"
			  ,Object[].class); return Arrays.asList(objects); }
			 
		@GetMapping("/findAllTrains")

		public List<Admin> showalltrains() {
			log.info("The available trains are viewed");
			return service.showalltrains();
		}

		@GetMapping("/findtrain/{id}")
		public ResponseEntity<Admin> showbyId(@PathVariable("id") String id) throws TrainIdNotFoundException {
			Admin admin = service.getbytrainid(id);
			log.info("The train " +id+ " is available");
			if (admin != null)
				return new ResponseEntity<>(admin, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		}
		@PutMapping("/update/{id}")
		@PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Admin> updateTrain(@PathVariable("id") String id ,@RequestBody Admin admin ) throws TrainIdNotFoundException
	    {
	        Admin s = service.updateTrain(admin);
	        log.info("The train " +id+ " is updated");
	        if(s!=null)
	             return new ResponseEntity<>(s,HttpStatus.OK);
	        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	        
	        
	    }
		@PostMapping("/addtrain")
		 @PreAuthorize("hasRole('ADMIN')")
	     public ResponseEntity<Admin> addTrain(@RequestBody Admin admin) throws TrainIdNotFoundException
	    {
	       
	        Admin a = service.addTrain(admin);
	        log.info("The train added successfully");
	        if(a!=null)
	            return new ResponseEntity<>(a,HttpStatus.CREATED);
	        else
	           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	        
	    }

		
		 @DeleteMapping("/deletetrain/{id}")
		 @PreAuthorize("hasRole('ADMIN')")
		    public ResponseEntity<String> deleteTrain(@PathVariable String id) throws TrainIdNotFoundException
		    {
		        String a = service.deleteTrain(id);
		        log.info("The train " +id+ " is deleted successfully");
		        if (a!=null)
		            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		        else
		            return new ResponseEntity<>("Could not found",HttpStatus.NOT_FOUND);
		        
		    }	
			    
			    
	 			
			    
			    

		
		}
