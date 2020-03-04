package com.spring.controller;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.consumingSOAPwebservice.springSOAPConsuming.CountryClient;
import com.spring.consumingSOAPwebservice.springSOAPConsuming.HotelClient;
import com.spring.consumingSOAPwebservice.wsdl.GetCountryResponse;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;

@Controller
public class GreetingController {
	
	@Autowired private CountryClient hotelClient;

	@GetMapping("/greeting")
	//@ResponseBody
	public String greeting(@RequestParam(name="name",required=false, defaultValue="karim") String name, Model model)
			//@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) 
	{
		String nom = "Montpellier";	
    	String dateDepart = "2020-02-19";
    	String dateArrivee = "2020-02-24";
    	String intervellePrix = "10.00-60.50";
    	int nombreEtoiles = 3;
    	int nombrePersonnesHebergees = 1;
    	
   
			GetCountryResponse response = hotelClient.getCountry("spain");
			//for(cie)
			System.err.println(response.getCountry());
		 
	      
		
		model.addAttribute("name", name);
		return "greeting";
	}

}
