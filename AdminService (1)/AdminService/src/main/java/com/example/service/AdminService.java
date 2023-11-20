package com.example.service;

import java.util.List;



import com.example.exception.TrainIdNotFoundException;
import com.example.models.Admin;


	public interface AdminService {
		public List<Admin> showalltrains();  
		public Admin getbytrainid( String id) throws TrainIdNotFoundException;
		public  String deleteTrain(String id) throws TrainIdNotFoundException;
		 public Admin updateTrain(Admin admin)throws TrainIdNotFoundException;
		 public Admin addTrain(Admin admin)throws TrainIdNotFoundException;	
			
		
		


}
