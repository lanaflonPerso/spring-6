package com.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.client.HotelClient;
import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;
import com.spring.consumingSOAPwebservice.wsdl.Offre;
import com.spring.consumingSOAPwebservice.wsdl.ReservationRequest;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;

@Controller
public class HotelController {
    private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

	@Autowired 
	private HotelClient hotelClient;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();

	  /*****************************************************************************/
	  /********************************  Offres d'hotel ****************************/
	  /*****************************************************************************/
	
	  @GetMapping("/")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "index";
	  }
	  
//	  @GetMapping("/")
//	  public String hokjhkjhme() {
//        return "index";
//      }

	  
	  @GetMapping("/offres")
	  public String OffreForm(Model model) {
	    model.addAttribute("RequestOffres", new GetHotelRequest());
	    return "offres-form";
	  }

	  @PostMapping("/offres")
	  public String OffreSubmit(@ModelAttribute("RequestOffres") GetHotelRequest RequestOffres, Model model) {
		  String login = RequestOffres.getLogin();
		  String password = RequestOffres.getPassword();
		  String dateDebut = RequestOffres.getDateDebut();
		  String dateFin = RequestOffres.getDateFin();
		  int nombrePersonnesHeberges = RequestOffres.getNombrePersonnesHeberges();
		  GetHotelResponse response = new GetHotelResponse();
		  response = hotelClient.getOffresHotel(login, password, dateDebut, dateFin, nombrePersonnesHeberges);
		  offres = response.getOffres();
		  
		  if(offres != null)
			  model.addAttribute("listOffre", offres);
		  else
			  model.addAttribute("listOffre", null);
			
	    return "offres-result";
	  }
	  
	  /*****************************************************************************/
	  /********************************  Reservation *******************************/
	  /*****************************************************************************/
	  
	  @GetMapping("/reservation")
	  public String reservationForm(Model model) {
	    model.addAttribute("reservationRequest", new ReservationRequest());
	    return "reservation-form";
	  }

	  @PostMapping("/reservation")
	  public String reservationSubmit(@ModelAttribute("reservationRequest") ReservationRequest reservationRequest, Model model) {
		  String login = reservationRequest.getLogin();
		  String password = reservationRequest.getPassword();
		  String idOffre = reservationRequest.getIdOffre();
		  Client client = reservationRequest.getClient();
		  
		 // Client cl = new Client();
		  //client.set
		  
		  System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + login);
		  System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ client nom " + client.getNom());
		  log.info("€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€bbbbbbbbbbbbbe" + client.getNom());
		  
		  ReservationResponse response = hotelClient.doReservation(login, password, idOffre,client);
		  confirmation = response.getConfirmation();
		 		  
		  model.addAttribute("confirmation", confirmation);
		  model.addAttribute("client", client);
			
	    return "reservation-result";
	  }

}
