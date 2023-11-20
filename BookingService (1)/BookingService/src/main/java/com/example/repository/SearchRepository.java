package com.example.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.Search;

public interface SearchRepository extends MongoRepository<Search, String> {

	

}
