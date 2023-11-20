package com.example.service;

import java.util.List;


import com.example.exception.TicketIdNotFoundException;
import com.example.models.BookedTickets;



public interface BookingService {
	 public List<BookedTickets> showalltickets();  
	 
	 public String deleteTicket(String id) throws TicketIdNotFoundException;
	 public BookedTickets updateTicket(BookedTickets book)throws TicketIdNotFoundException;
	 public BookedTickets addTicket(BookedTickets book)throws TicketIdNotFoundException;
	 public BookedTickets getbytrainid(String id) throws TicketIdNotFoundException;	
		
}
