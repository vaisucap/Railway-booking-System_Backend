package com.trainsearch.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainsearch.exception.TrainIdNotFoundException;
import com.trainsearch.models.Search;
import com.trainsearch.repository.SearchRepository;

@Service
	public class SearchImpl implements SearchService{
	    @Autowired
	    SearchRepository repository;
	    
	    @Override
	    public List<Search> showalltrains()
	    {
	    	return repository.findAll();
	    }
	    
	    
	    
@Override


public Search getbytrainid(String id) throws TrainIdNotFoundException
{
	//log.info("Start");
	Optional<Search> search=repository.findById(id);
	if(search.isPresent())
	{
		//log.info("end");
		return search.get();
	}
	else
	{
		return search.orElseThrow(()->new TrainIdNotFoundException(id+"doesn not exists"));
	}
}}

