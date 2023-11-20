package com.example;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

 
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 

import java.util.stream.Collectors;
import java.util.stream.Stream;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

 

import com.example.exception.TicketIdNotFoundException;
import com.example.models.BookedTickets;
import com.example.repository.BookingRepository;
import com.example.service.BookingService;

 


@SpringBootTest
class TrainBookingServiceApplicationTests {

 

    
        @Autowired
        private BookingService bookingService;

 

 

 

      @MockBean
        private BookingRepository bookingRepository;

           @Test
            public void showallTrainsTest() throws TicketIdNotFoundException {
             when(bookingRepository.findAll()).thenReturn( Stream
                     .of(new BookedTickets("10000","Myld","Mysore","3","ac","ac","123456","ac")).collect(Collectors.toList()));
                    assertEquals(1,bookingService.showalltickets().size());
            }

            @Test
            public void addTrainDetailsTest() throws TicketIdNotFoundException{
                  BookedTickets book=new BookedTickets("10000","Myld","Mysore","3","ac","ac","123456","ac");
                  when(bookingRepository.insert(book)).thenReturn(book);
                  assertEquals(book, bookingService.addTicket(book));
              }

           @Test
            public BookedTickets updateTrainDetailsTest() throws TicketIdNotFoundException {
               BookedTickets book=new BookedTickets("10000","Myld","Mysore","3","ac","ac","123456","ac");
            when(bookingRepository.save(book)).thenReturn(book);
            assertEquals(book,bookingService.updateTicket(book));
            return book;
            }
           @Test
           public void getTrainbyidTest() throws TicketIdNotFoundException{
               String id="10000";
               try {
                   bookingService.getbytrainid(id);
                   }
               catch(TicketIdNotFoundException e) {
                   System.out.println(e); 

               }
           }

           @Test
            public BookedTickets deleteTrainDetails() throws TicketIdNotFoundException {
               BookedTickets book=new BookedTickets("10000","Myld","Mysore","3","ac","ac","123456","ac");
               bookingService.deleteTicket("1");
            verify(bookingRepository,times(1)).delete(book);
            return book;
            }
    }