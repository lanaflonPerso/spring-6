package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.client.HotelClient;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;
import com.spring.consumingSOAPwebservice.wsdl.Offre;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;

@Controller
public class HotelController {
	
	@Autowired 
	private HotelClient hotelClient;
	private List<Offre> offres = new ArrayList<Offre>();

	  @GetMapping("/offres")
	  public String greetingForm(Model model) {
	    model.addAttribute("RequestOffres", new GetHotelRequest());
	    return "offres-form";
	  }

	  @PostMapping("/offres")
	  public String greetingSubmit(@ModelAttribute("RequestOffres") GetHotelRequest RequestOffres, Model model) {
		  String login = RequestOffres.getLogin();
		  String password = RequestOffres.getPassword();
		  String dateDebut = RequestOffres.getDateDebut();
		  String dateFin = RequestOffres.getDateFin();
		  int nombrePersonnesHeberges = RequestOffres.getNombrePersonnesHeberges();
		  
		  GetHotelResponse response = hotelClient.getOffresHotel(login, password, dateDebut, dateFin, nombrePersonnesHeberges);
		  offres = response.getOffres();
		  for(Offre off: offres) {
				System.err.println("############"+ off.getDateDisponibilite());
				System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
		
				      model.addAttribute("listOffre", offres);
			
	    return "offres-result";
	  }

}
