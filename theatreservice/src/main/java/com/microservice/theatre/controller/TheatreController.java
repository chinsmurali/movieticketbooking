
package com.microservice.theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microservice.theatre.modal.Theatre;
import com.microservice.theatre.service.TheatreService;


@RestController
@CrossOrigin(origins="http://localhost:4200") 
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	

	@GetMapping("/gettheatres")
	public List<Theatre> fetchByZipcode(Integer zipcode)
	{
		return this.theatreService.fetchByZipcode(zipcode);		
	}
	
	
	
	//This will add Theatre , Screens with Static data.
	@PostMapping("/addTheatre")
	String setTheatre()
	{
		
		this.theatreService.AddTheatreRepo();
		
		return "theatre added";
	}
	
	
	
}