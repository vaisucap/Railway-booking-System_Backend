package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AmountNotFoundException;
import com.example.exception.TrainIdNotFoundException;
import com.example.models.Fare;
import com.example.repository.FareRepository;


@Service
public class FareServiceImpl implements FareService {

    @Autowired
    FareRepository repository;
    
    
    
	@Override
    public List<Fare> showalltrainsfare()
    {
    	return repository.findAll();
    }
    
	@Override


    public Fare getfarebytrainid(String id) throws TrainIdNotFoundException
    {
    	//log.info("Start");
    	Optional<Fare> search=repository.findById(id);
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
    public Fare updateFare( Fare fare) throws TrainIdNotFoundException
    {
       // log.info("Start");
        Optional<Fare> f = repository.findById(fare.getTrainid());
        if (!f.isPresent())
        {
            
            return f.orElseThrow(()-> new TrainIdNotFoundException("Train Doesnot exists"));
        }
        else
            //log.info("end");
           return repository.save(fare);
        
        
        
    }
    @Override
    public Fare addFare(Fare fare) throws TrainIdNotFoundException
    {
       // log.info("Start");
        Optional<Fare> c = repository.findById(fare.getTrainid());
        if (c.isPresent())
        {
            return c.orElseThrow(()-> new TrainIdNotFoundException("TrainId already exists"));
        }
        else
            //log.info("end");
           return repository.insert(fare);
    }
    @Override
    public String deleteFare(String id)throws TrainIdNotFoundException
    {



       //log.info("Start");
        Optional<Fare> a = repository.findById(id);
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
	@Override
	public Fare gettrainbyamount(String amount) throws AmountNotFoundException {
		
		    	//log.info("Start");
		    	Optional<Fare> search=repository.findById(amount);
		    	if(search.isPresent())
		    	{
		    		//log.info("end");
		    		return search.get();
		    	}
		    	else
		    	{
		    		return search.orElseThrow(()->new AmountNotFoundException(amount+" does not exists"));
		    	}
		    }
	}


