package com.spring.controller;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.consumingSOAPwebservice.springSOAPConsuming.HotelClient;
import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;



@Controller
public class GreetingController {
	
	@Autowired 
	private HotelClient hotelClient;

	@GetMapping("/greeting")
	//@ResponseBody
	public String greeting(@RequestParam(name="name",required=false, defaultValue="karim") String name, Model model)
			//@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) 
	{
		String login = "karim";	
    	String password = "dahdouh";
    	String idOffre = "50_04-03-2020";
    	Client client = new Client();
    	client.setId(13);
    	client.setNom("Barry");
    	client.setPrenom("Theirno");
    	client.setCarteCredit("5088734328394382");
    	
   
			ReservationResponse response = hotelClient.getReservation(login, password, idOffre, client);
			for(String c: response.getConfirmation()) {
				System.err.println("############"+ response.getConfirmation());
				System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
			System.err.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		 
	      
		
		model.addAttribute("name", name);
		return "greeting";
	}

}
