package com.microservice.offerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modal.Offer;

public interface CityRepo extends JpaRepository<Offer, Integer> {

	public Offer findByOffer(String offer);
	
	@Query("from Offer")
	public List<Offer> oncat(String offer);
	
	public List<Offer> FindByOfferName(String offerName);

}
