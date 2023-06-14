package com.microservice.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.User;


public interface ResistrationRepository extends JpaRepository<User, Integer>
{

	public User findByEmail(String email);
	
	public User findByEmailAndUserPassword(String email , String userPassword);  
}