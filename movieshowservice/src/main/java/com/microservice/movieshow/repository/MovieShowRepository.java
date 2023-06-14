package com.microservice.movieshowservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservice.movieshowservice.modal.City;

public interface MovieRepo extends JpaRepository<movieId, Integer> {

	public Movie findByCity(String MovieNasme);
	
	@Query("from Movie")
	public List<Movie> oncat(String movie);
	
	public List<Movie> FindBy MovieName(String movieName);

}