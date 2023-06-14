package com.microservice.city.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.city.repository.CityRepo;
import com.microservice.city.modal.City;

@Service
public class CityService 
{
	@Autowired
	CityRepo repo;
	
	public List<City> fetchByCityName(String city)
	{
		
		return repo.oncat(city);
		
	}

	
	
}