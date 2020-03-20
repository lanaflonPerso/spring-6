package com.karim.Restfull.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.karim.Restfull.model.Client;
import com.karim.Restfull.model.GetHotelRequest;
import com.karim.Restfull.model.Offre;


@Controller
public class HotelController {
    private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired 
	private RestTemplate restTemplate;
	//private HotelClient hotelClient;
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
		  
		  String uri = "https://hotel-webservice-restful.cfapps.io/offres/"+login+"/"+password+"/"+dateFin+"/"+dateFin+"/"+nombrePersonnesHeberges;
		  Offre[] offs = restTemplate.getForObject(uri, Offre[].class);
		  offres = Arrays.asList(offs);
		   
		  if(offres != null)
			  model.addAttribute("listOffre", offres);
		  else
			  model.addAttribute("listOffre", null);
			
	    return "offres-result";
	  }
	
	  /*****************************************************************************/
	  /********************************  Reservation *******************************/
	  /*****************************************************************************/
	  
	  @GetMapping("/reservation/{idOffre}")
	  public String reservationForm(@PathVariable String idOffre, Model model) {
		ReservationRequest rq = new ReservationRequest();
		rq.setIdOffre(idOffre);
		model.addAttribute("reservationRequest", rq);
	    return "reservation-form";
	  }

	  @PostMapping("/reservation")
	  public String reservationSubmit(@ModelAttribute("reservationRequest") ReservationRequest reservationRequest, Model model) {
		  String login = reservationRequest.getLogin();
		  String password = reservationRequest.getPassword();
		  String idOffre = reservationRequest.getIdOffre();
		  Client client = reservationRequest.getClient();
		  
		  String uri = "https://hotel-webservice-restful.cfapps.io/reservation/"+login+"/"+password+"/"+idOffre+"/"+client.getNom()+"/"+client.getPrenom()+"/"+client.getCarteCredit();
		  String[] conf = restTemplate.getForObject(uri, String[].class);
		  confirmation = Arrays.asList(conf);

		  model.addAttribute("confirmation", confirmation);
		  model.addAttribute("client", client);
			
	    return "reservation-result";
	  }

}
