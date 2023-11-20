package com.example.service;


import java.util.List;

import com.example.exception.AmountNotFoundException;
import com.example.exception.TrainIdNotFoundException;
import com.example.models.Fare;

public interface FareService {

	



	public List<Fare> showalltrainsfare();

	 

	Fare updateFare(Fare fare) throws TrainIdNotFoundException;

	Fare addFare(Fare fare) throws TrainIdNotFoundException;

	String deleteFare(String id) throws TrainIdNotFoundException;

	

	



	



	Fare getfarebytrainid(String id) throws TrainIdNotFoundException;



	Fare gettrainbyamount(String amount) throws AmountNotFoundException;
	

}
