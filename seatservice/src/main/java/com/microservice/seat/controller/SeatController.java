
package com.microservice.seat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.seat.model.MySeat;
import com.microservice.seat.movieshow.ShowDummy;
import com.microservice.seat.model.Seat;
import com.microservice.seat.service.SeatService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SeatController {


	@Autowired
	SeatService seatService;
	
	@PostMapping("/listofseats")
	List<MySeat> GetListOfSeats(@RequestBody ShowDummy show)
	{
		System.out.println("show "+show);
		return seatService.GetListOfSeats(show.getShowId());
	}
	
	@PostMapping("/setseat")
	List<MySeat> selectSeat(@RequestBody List<MySeat> seats)
	{
		System.out.println("called setseat");
		seats.forEach(System.out::println);
		
		return seatService.setSeat(seats);
	}
	
	
}