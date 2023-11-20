package com.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.models.BookedTickets;



@Repository
public interface BookingRepository extends MongoRepository<BookedTickets,String>{

}
