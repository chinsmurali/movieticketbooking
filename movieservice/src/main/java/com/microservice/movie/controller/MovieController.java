
package com.microservice.movie.controller;

import java.util.List;


import com.microservice.movie.modal.Movies;
import com.microservice.movie.service.MovieService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MovieController
{
	@Autowired
	MovieService movieService;
	
	
	@PostMapping("/addmovie")
	List<Movies> addMovie(@RequestBody List<Movies> movies)
	{
		System.out.println("addMovie fun called");
//		System.out.println(movies);
		return movieService.addMovie(movies);
	}
	
	@GetMapping("/getmovielist")
	List<Movies> getMovieList()
	{
		return movieService.getMovieList();
	}
	
	

}