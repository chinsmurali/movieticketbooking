package com.microservice.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.theatre.dao.ScreenRepo;
import com.microservice.theatre.dao.TheatreRepo;
import com.microservice.theatre.modal.Screen;
import com.microservice.theatre.modal.Theatre;

@Service
public class TheatreService {
	
	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	ScreenRepo screenRepo;

	public List<Theatre> fetchByZipcode(Integer zipcode)
	{
		return theatreRepo.oncat(zipcode);		
	}
	
	public void AddTheatreRepo( )
	{	

		
        String theatrename = "PVRTheatre";
		Integer zipcode = 556644;		//check that its available in city table;
		Integer totalscreens = 6;
		int[] totalSeatsArray = new int[]{ 44,25,55,33,44,55}; 
		
		
		//--------------------

	//Theater :
		theatreRepo.insertTheatreByParam( theatrename ,  totalscreens , zipcode );
	//Screens :
		Theatre theatre = theatreRepo.findByTheatreName(theatrename);
		
		for (int i = 1; i <= totalscreens; i++) 
		{
			Integer totalNoOfSeats = totalSeatsArray[i-1]; 
		
			Screen screen = new Screen();
			screen.setTotalNoOfSeats(totalNoOfSeats);
			
			screen.setScreenName("Screen"+i);
			
			screen.setTheatre(theatre);
			
			screenRepo.save(screen);	
		
		//Seats :
//			for (int j = 1; j <= totalNoOfSeats; j++) 
//			{				
//				Seat seat = new Seat();
//				seat.setScreen(screen);
//				seat.setSeatNumber(j);
//				
//				seatRepo.save(seat);
//			}	
		}
	}
}