package com.microservice.offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;


import com.microservice.offer.modal.offer;
import com.microservice.offer.service.OfferService;


@RestController
@CrossOrigin(origins="http://localhost:4200") 
public class OfferController {

	@Autowired
	OfferService service;
	
	
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
	
	@GetMapping("/offer")
	public List<Offer> fetchByCityName(String offer)
	{
		return this.service.fetchByOfferName(offer);
	}
	
	public double applyDiscount(String showTime, int totalTickets, double ticketPrice) {
        double discount = 0;
        if (totalTickets >= 3) {
            discount += 0.5 * ticketPrice; // 50% on 3rd
        }
        if (showTime.contains("12:00") || showTime.contains("13:00")) {
            discount += 0.2 * ticketPrice * totalTickets; // 20% for afternoon
        }
        return discount;
    }
}

