package com.microservice.offer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.offer.repository.OfferRepo;
import com.microservice.offer.modal.Offer;

@Service
public class OfferService 
{
	@Autowired
	OfferRepo repo;
	
	public List<Offer> fetchByOfferName(String offer)
	{
		
		return repo.oncat(offer);
		
	}

	
	
}
