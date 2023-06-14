package com.microservice.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer> 
{

}	