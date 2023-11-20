package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TicketIdNotFoundException;
import com.example.models.BookedTickets;
import com.example.repository.BookingRepository;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository repository;
    
    @Override
    public List<BookedTickets> showalltickets()
    {
    	return repository.findAll();
    }
    
    
    
@Override


public BookedTickets getbytrainid(String id) throws TicketIdNotFoundException
{
//log.info("Start");
Optional<BookedTickets> search=repository.findById(id);
if(search.isPresent())
{
	//log.info("end");
	return search.get();
}
else
{
	return search.orElseThrow(()->new TicketIdNotFoundException(id+" does not exists"));
}
}

@Override
public BookedTickets updateTicket(BookedTickets book) throws TicketIdNotFoundException
{
// log.info("Start");
Optional<BookedTickets> f = repository.findById(book.getTrain_id());
if (!f.isPresent())
{
    
    return f.orElseThrow(()-> new TicketIdNotFoundException("Ticket Doesnot exists"));
}
else
    //log.info("end");
   return repository.save(book);



}
@Override
public BookedTickets addTicket(BookedTickets  book) throws TicketIdNotFoundException
{
// log.info("Start");
Optional<BookedTickets> c = repository.findById(book.getTrain_id());
if (c.isPresent())
{
    return c.orElseThrow(()-> new TicketIdNotFoundException("Ticket already exists"));
}
else
    //log.info("end");
   return repository.insert(book);
}


@Override
public String deleteTicket(String id)throws TicketIdNotFoundException
{



//log.info("Start");
Optional<BookedTickets> a = repository.findById(id);
if (!a.isPresent())
{
    a.orElseThrow(()-> new TicketIdNotFoundException("Ticket Doesnot exists"));
    return "Could not Delete";
}
else
   {
    //log.info("end");
    repository.deleteById(id);
    return "Deleted Successfully";
   }

}






}



