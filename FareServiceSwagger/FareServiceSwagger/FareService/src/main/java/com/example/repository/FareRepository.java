package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Fare;
import com.example.models.User;
@Repository
public interface FareRepository extends MongoRepository<Fare,String>{

	

}
