package com.microservice.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.city.repository.MovieRepo;
import com.microservice.city.modal.Movie;

@Service
public class MovieService 
{
	@Autowired
	MovieRepo repo;
	
	public List<City> fetchByMovieName(String movie)
	{
		
		return repo.oncat(movie);
		
	}

	
	
}