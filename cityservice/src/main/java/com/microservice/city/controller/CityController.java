
package com.microservice.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

import com.microservice.city.classes.SetCity;
import com.microservice.city.modal.City;
import com.microservice.city.service.CityService;


@RestController
@CrossOrigin(origins="http://localhost:4200") 
public class CityController {

	@Autowired
	CityService service;
	
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
	@Autowired
	private HttpBinService httpBin;
	
	
	public CityController(CircuitBreakerFactory circuitBreakerFactory, HttpBinService httpBin) {
		super();
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.httpBin = httpBin;
	}
	
	
//	public Integer zcode;
	
	@GetMapping("/city")
	public List<City> fetchByCityName(String city)
	{
		return this.service.fetchByCityName(city);
	}
	
	@PostMapping("/setcity")
	public SetCity setCity(SetCity city)
	{
		System.out.println(city);
		City.setStaticCity(city.getCityname());
		
		System.out.println(City.getStaticCity());
		
		return city;
	}
	
	@GetMapping("checklocation")
	Boolean checkLocation()
	{
		if (City.getStaticCity() != "") 
		{
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
}