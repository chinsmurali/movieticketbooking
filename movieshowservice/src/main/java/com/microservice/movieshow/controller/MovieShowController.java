
package com.microservice.movieshow.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.movie.modal.MoviesHow;
import com.microservice.movie.service.MovieHowService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MovieHowController
{
	@Autowired
	MovieHowService movieHowService;
	
	
	@PostMapping("/addmovie")
	List<Movies> addMovie(@RequestBody List<Movies> movies)
	{
		System.out.println("addMovie fun called");
//		System.out.println(movies);
		return movieHowService.addMovie(movies);
	}
	
	@GetMapping("/getmovielist")
	List<Movies> getMovieList()
	{
		return movieHowService.getMovieList();
	}
	
	
										 
}