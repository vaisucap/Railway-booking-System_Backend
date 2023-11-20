package com.example.models;
//
//import org.springframework.data.annotation.Id;

import java.util.Date;

//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection="Search")
//public class Fare {
//	@Id
//	private String trainid;
//	private String trainname;
//	private String source;
//	private String destination;
//	private String amount;
//	
//	
//	public String getTrainid() {
//		return trainid;
//	}
//	public void setTrainid(String trainid) {
//		this.trainid = trainid;
//	}
//	public String getTrainname() {
//		return trainname;
//	}
//	public void setTrainname(String trainname) {
//		this.trainname = trainname;
//	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public String getDestination() {
//		return destination;
//	}
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//	public String getAmount() {
//		return amount;
//	}
//	public void setAmount(String amount) {
//		this.amount = amount;
//	}
//	public Fare() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "Fare [trainid=" + trainid + ", trainname=" + trainname + ", source=" + source + ", destination="
//				+ destination + ", amount=" + amount + "]";
//	}
//	
//	
//	
//	
//
//}

























import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Search")
public class Fare {
	@Id
	@NotNull (message="Train Id is required")
	@Min(value=1,message="Id should not be Zero and Negative values")
	private String trainid;
	@Field
	@NotBlank(message="Source (from-location)should not be empty")
	@Size(max=50)
	private String source;
	@Field
	@NotBlank(message="Destination (to-location)should not be empty")
	@Size(max=50)
	private String destination;
	private String firstname;
	private String lastname;
	private Long contactno;
	private String seats;
	private double amount;
	private String trainname;
	private Date travellingdate;
	public Fare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fare(
			@NotNull(message = "Train Id is required") @Min(value = 1, message = "Id should not be Zero and Negative values") String trainid,
			@NotBlank(message = "Source (from-location)should not be empty") @Size(max = 50) String source,
			@NotBlank(message = "Destination (to-location)should not be empty") @Size(max = 50) String destination,
			String firstname, String lastname, Long contactno, String seats, double amount, String trainname,Date travellingdate) {
		super();
		this.trainid = trainid;
    	this.source = source;
		this.destination = destination;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.seats = seats;
		this.amount = amount;
		this.trainname = trainname;
		this.travellingdate=travellingdate;
	}
	public String getTrainid() {
		return trainid;
	}
	public void setTrain_id(String trainid) {
		this.trainid = trainid;
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
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public Date getTravellingdate() {
		return travellingdate;
	}
	public void setTravellingdate(Date travellingdate) {
		this.travellingdate = travellingdate;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	@Override
	public String toString() {
		return "Fare [trainid=" + trainid + ", source=" + source + ", destination=" + destination + ", firstname="
				+ firstname + ", lastname=" + lastname + ", contactno=" + contactno + ", seats=" + seats + ", amount="
				+ amount + ", trainname=" + trainname + ", travellingdate=" + travellingdate + "]";
	}
	
	
	
	

}
