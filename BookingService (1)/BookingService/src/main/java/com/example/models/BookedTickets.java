package com.example.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



 
@Document(collection = "BookedTicket")
public class BookedTickets {
	@Id
	private String train_id;
	@Field
	private String source;
	@Field
	private String destination;
	@Field
	private String seats;
	@Field
	private String firstname;
	@Field
	private String lastname;
	@Field
	private String contactno;
	@Field
	private String coach;
	
	public BookedTickets(String train_id, String source, String destination, String seats, String firstname,
			String lastname, String contactno, String coach) {
		super();
		this.train_id = train_id;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.coach = coach;
	}
	public String getTrain_id() {
		return train_id;
	}
	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	
}
 















