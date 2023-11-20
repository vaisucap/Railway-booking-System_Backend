package com.trainsearch.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.trainsearch.models.Search;

public interface SearchRepository extends MongoRepository<Search, String> {

	

}
