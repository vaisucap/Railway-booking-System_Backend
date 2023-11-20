package com.trainsearch.controller;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trainsearch.*;
import com.trainsearch.exception.TrainIdNotFoundException;
import com.trainsearch.models.*;
import com.trainsearch.repository.SearchRepository;
import com.trainsearch.service.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600 ,allowCredentials="true")
public class SearchController {
	Logger log = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchService service;

	@GetMapping("/findAllTrains")

	public List<Search> showalltrains() {
		log.info ("all trains are found");
		return service.showalltrains();
	}

	@GetMapping("/findtrain/{id}")
	public ResponseEntity<Search> showbyId(@PathVariable("id") String id) throws TrainIdNotFoundException {
		Search search = service.getbytrainid(id);
		
		if (search != null)
			return new ResponseEntity<>(search, HttpStatus.OK);
		else
			log.info ("all trains"+id+" are found");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}
}
