package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.exception.TrainIdNotFoundException;
import com.example.models.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	
	    @Autowired
	    AdminRepository repository;
	    
	    @Override
	    public List<Admin> showalltrains()
	    {
	    	return repository.findAll();
	    }
 	    
	    
	    
@Override


public Admin getbytrainid(String id) throws TrainIdNotFoundException
{
	//log.info("Start");
	Optional<Admin> search=repository.findById(id);
	if(search.isPresent())
	{
		//log.info("end");
		return search.get();
	}
	else
	{
		return search.orElseThrow(()->new TrainIdNotFoundException(id+" does not exists"));
	}
}

@Override
public Admin updateTrain(Admin admin) throws TrainIdNotFoundException
{
   // log.info("Start");
    Optional<Admin> f = repository.findById(admin.getTrainid());
    if (!f.isPresent())
    {
        
        return f.orElseThrow(()-> new TrainIdNotFoundException("Train Does not exists"));
    }
    else
        //log.info("end");
       return repository.save(admin);
    
    
    
}
@Override
public Admin addTrain(Admin  admin) throws TrainIdNotFoundException
{
   // log.info("Start");
    Optional<Admin> c = repository.findById(admin.getTrainid());
    if (c.isPresent())
    {
        return c.orElseThrow(()-> new TrainIdNotFoundException("TrainId already exists"));
    }
    else
        //log.info("end");
       return repository.insert(admin);
}


@Override
public String deleteTrain(String id)throws TrainIdNotFoundException
{



   //log.info("Start");
    Optional<Admin> a = repository.findById(id);
    if (!a.isPresent())
    {
        a.orElseThrow(()-> new TrainIdNotFoundException("Train Doesnot exists"));
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



	



   

