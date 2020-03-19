package com.spring.karim.restful.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.karim.restful.model.AgenceVoyage;
import com.spring.karim.restful.model.Chambre;
import com.spring.karim.restful.model.Client;
import com.spring.karim.restful.model.Employee;
import com.spring.karim.restful.model.Hotel;
import com.spring.karim.restful.model.Offre;
import com.spring.karim.restful.repository.AgenceVoyageRepository;
import com.spring.karim.restful.repository.ChambreRepository;
import com.spring.karim.restful.repository.ClientRepository;
import com.spring.karim.restful.repository.EmployeeRepository;
import com.spring.karim.restful.repository.HotelRepository;
import com.spring.karim.restful.repository.ReservationRepository;
import com.spring.karim.restful.model.Reservation;


@RestController
public class HotelController {
 	  
	private HotelRepository hotelRepository;
	private ReservationRepository reservationRepository;
	private AgenceVoyageRepository agenceVoyageRepository;
	private ChambreRepository chambreRepository;
	private ClientRepository clientRepository;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();

	private Hotel hotel = new Hotel();
	private List<Chambre> listChambres = new ArrayList<Chambre>();
	private AgenceVoyage agencesVoyages = new AgenceVoyage();

	
	public HotelController(HotelRepository hotelRepository, ReservationRepository reservationRepository, 
			AgenceVoyageRepository agenceVoyageRepository, ChambreRepository chambreRepository, ClientRepository clientRepository) {
		this.hotelRepository = hotelRepository;
		this.reservationRepository = reservationRepository;
		this.agenceVoyageRepository = agenceVoyageRepository;
		this.chambreRepository = chambreRepository;
		this.clientRepository = clientRepository;
	}
	  
	// Aggregate root

	@GetMapping("/offres/{login}/{password}/{dateDebut}/{dateFin}/{nombrePersonnesHeberges}")
	public List<Offre> getOffres(@PathVariable String login, @PathVariable String password, @PathVariable String dateDebut, @PathVariable String dateFin, @PathVariable int nombrePersonnesHeberges) {
		if(!offres.isEmpty())
			offres.clear();
		hotel = hotelRepository.findHotel(1);	
		agencesVoyages = agenceVoyageRepository.findAgenceVoyage(login, password);
		if (agencesVoyages != null) {
			if (hotel.getChambre().size() >= nombrePersonnesHeberges) {
				for (Chambre ch : hotel.getChambre()) {
					if (ch.getDisponible().equals("yes")) {
						Offre offr = new Offre();
						offr.setId(ch.getNumero() + "_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
						offr.setDateDisponibilite("05-03-2020");
						offr.setTypeChambre(ch.getTypeLit());
						offr.setPrix((agencesVoyages.getTarif() * ch.getPrix()) / 100);
						offres.add(offr);
					}
				}
			}
		} 
		
		return offres;
	}
	
	@GetMapping("/reservation/{login}/{password}/{idOffre}/{nom}/{prenom}/{carteCredit}")
	public List<String> Reservation(@PathVariable String login, @PathVariable String password, @PathVariable String idOffre, 
			@PathVariable String nom, @PathVariable String prenom, @PathVariable String carteCredit) {
		if(!confirmation.isEmpty())
			confirmation.clear();
		Reservation res = new Reservation();
		Client client = clientRepository.searchClient(nom, prenom, carteCredit);
		if(client == null) {
			Client newClient = new Client();
			newClient.setNom(nom);
			newClient.setPrenom(prenom);
			newClient.setCarteCredit(carteCredit);
			clientRepository.save(newClient);
			res.setClient(newClient);
		} else  {
			res.setClient(client);
		}

		Chambre chambre = chambreRepository.findById(1).orElse(null);
		res.setChambre(chambre);
		AgenceVoyage agenceVoyage = agenceVoyageRepository.findAgenceVoyage(login, password);
		res.setAgenceVoyage(agenceVoyage);
		res.setDateArrivee("2020-03-05");
		res.setDateDepart("2020-03-09");		
		reservationRepository.save(res);
		
		confirmation.add("Reservation  a été bien faite.");
		return confirmation;
	}
	
	@GetMapping(
			  value = "/get-image-with-media-type/{id}",
			  produces = MediaType.IMAGE_JPEG_VALUE
			)

	public @ResponseBody byte[] getImageWithMediaType(@PathVariable String id) throws IOException {
		//InputStream in = getClass().getResourceAsStream(id+".jpg");
		//InputStream in = new FileInputStream("/home/karim/Documents/sping/springRESTfulBuilding/src/main/java/com/spring/karim/restful/controller"+id+".jpg");

		InputStream in = getClass().getClassLoader().getResourceAsStream("static/image/"+id+".jpg");
		return IOUtils.toByteArray(in);
	}


}
