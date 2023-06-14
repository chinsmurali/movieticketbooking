package com.microservice.movieshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.repository.ResistrationRepo;
import com.microservice.registration.modal.User;

@Service
public class RegistrationService
{

	@Autowired
	ResistrationRepo repo;
	

	
	public User saveUser(User user)
	{
		repo.save(user);
		return user;
	}
	
	public User fetchUserByEmail(String email) {
		
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndUserPassword(String email , String userPassword)
	{
		return repo.findByEmailAndUserPassword(email, userPassword);
	}
}