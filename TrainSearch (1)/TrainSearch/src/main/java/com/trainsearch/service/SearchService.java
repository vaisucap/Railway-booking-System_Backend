package com.trainsearch.service;

import java.util.List;

import com.trainsearch.exception.TrainIdNotFoundException;
import com.trainsearch.models.Search;

public interface SearchService {
	public List<Search> showalltrains();  
	public Search getbytrainid( String id) throws TrainIdNotFoundException;
	


	
}
