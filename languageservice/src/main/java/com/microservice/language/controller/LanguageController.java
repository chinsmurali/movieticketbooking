
package com.microservice.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.city.classes.SetCity;
import com.microservice.language.modal.Language;
import com.microservice.language.service.LanguageService;


@RestController
@CrossOrigin(origins="http://localhost:4200") 
public class LanguageController {

	@Autowired
	LanguageService service;
	
	
//	public Integer zcode;
	
	@GetMapping("/language")
	public List<Language> getAllLanguageDetails(String language)
	{
		return this.service.getAllLanguageDetails(language);
	}
	
	@PostMapping("/setlanguage")
	public void setLanguage(String language)
	{
		System.out.println(language);
		language.acceptLanguageDetails(language.getLanguageName());
		
		System.out.println(language.getLanguageName());
		
		return language;
	}
	
	@PostMapping("/deletelanguage")
	public void deleteLanguage(int languageId)
	{
		System.out.println(languageId);
		language.deleteLanguage(languageId);
		
		System.out.println(language.getLanguageName());
		
		
	}
	
	@GetMapping("checklanguage")
	Boolean getLanguageDetails(int languageId)
	{
		service.getLanguageDetails(langaugaeId);
	}
	
	
	
	
	
	
	
	
	
	
}