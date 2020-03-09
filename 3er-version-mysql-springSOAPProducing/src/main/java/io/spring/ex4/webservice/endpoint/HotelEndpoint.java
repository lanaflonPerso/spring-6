package io.spring.ex4.webservice.endpoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.ex4.webservice.AgenceVoyage;
import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Client;
import io.spring.ex4.webservice.GetHotelRequest;
import io.spring.ex4.webservice.GetHotelResponse;
import io.spring.ex4.webservice.Hotel;
import io.spring.ex4.webservice.Offre;
import io.spring.ex4.webservice.Reservation;
import io.spring.ex4.webservice.ReservationRequest;
import io.spring.ex4.webservice.ReservationResponse;
import io.spring.ex4.webservice.Repository.AgenceVoyageRepository;
import io.spring.ex4.webservice.Repository.ChambreRepository;
import io.spring.ex4.webservice.Repository.ClientRepository;
import io.spring.ex4.webservice.Repository.HotelRepository;
import io.spring.ex4.webservice.Repository.ReservationRepository;


@Endpoint
public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";


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

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository, ReservationRepository reservationRepository, AgenceVoyageRepository agenceVoyageRepository, ChambreRepository chambreRepository, ClientRepository clientRepository) {
		this.hotelRepository = hotelRepository;
		this.reservationRepository = reservationRepository;
		this.agenceVoyageRepository = agenceVoyageRepository;
		this.chambreRepository = chambreRepository;
		this.clientRepository = clientRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
	@ResponsePayload
	public GetHotelResponse getOffres(@RequestPayload GetHotelRequest request) {
		GetHotelResponse response = new GetHotelResponse();
		hotel = hotelRepository.findHotel(1);	
		agencesVoyages = agenceVoyageRepository.findAgenceVoyage(request.getLogin(), request.getPassword());
										
		if (hotel.getChambre().size() >= request.getNombrePersonnesHeberges()) {
			for (Chambre ch : hotel.getChambre()) {
				// tester la disponibilité, et l'intervalle de prix demandé par le client.
				if (ch.getDisponible().equals("yes")) {
					Offre offr = new Offre();
					// identifiant de l'offre est le numéro de chambre concaténer avec la date d'oujourd'hui
					offr.setId(ch.getNumero() + "_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
					offr.setDateDisponibilite("05-03-2020");
					offr.setTypeChambre(ch.getTypeLit());
					offr.setPrix((agencesVoyages.getTarif() * ch.getPrix()) / 100);
					// ajouter la chambre à la liste des offres disponibles
					offres.add(offr);				}
			}
		} 
		
		response.getOffres().addAll(offres);
		System.out.println("Agence login: "+ request.getLogin());
		System.out.println(" Agence voyage password:  "+ request.getPassword());
		System.out.println(" Nombre de personnes: "+ request.getNombrePersonnesHeberges());
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReservationRequest")
	@ResponsePayload
	public ReservationResponse reservation(@RequestPayload ReservationRequest request) {
		ReservationResponse response = new ReservationResponse();
		
		//confirmation = reservationRepository.confirmerReservation(request.getLogin(), request.getPassword(), request.getIdOffre(), request.getClient());
		
		System.out.println("######################################################");
		
		Reservation res = new Reservation();
		Client client = clientRepository.searchClient(request.getClient().getNom(), request.getClient().getPrenom(), request.getClient().getCarteCredit());
		if(client == null) {
			Client newClient = new Client();
			newClient.setId(request.getClient().getId());
			newClient.setNom(request.getClient().getNom());
			newClient.setPrenom(request.getClient().getPrenom());
			newClient.setCarteCredit(request.getClient().getCarteCredit());
			clientRepository.save(newClient);
		} else  {
			System.out.println("#$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ client existant");
			res.setClient(client);
		}

		
		Chambre chambre = chambreRepository.findById(1).orElse(null);
		res.setChambre(chambre);
		AgenceVoyage agenceVoyage = agenceVoyageRepository.findAgenceVoyage(request.getLogin(), request.getPassword());
		res.setAgenceVoyage(agenceVoyage);
		res.setDateArrivee("2020-03-05");
		res.setDateDepart("2020-03-09");		
				reservationRepository.save(res);
		
		confirmation.add("Reservation  été bien faite.");
		confirmation.add(request.getIdOffre());
		System.out.println("Reservation  été bien faite.");
		
		response.getConfirmation().addAll(confirmation);
		System.out.println("la reservation de Mr. "+ request.getClient().getPrenom() + " "+ request.getClient().getNom());
		System.out.println("identifiant Offre: "+ confirmation.get(1));
		System.out.println("message de confirmation: "+ confirmation.get(0));
		
		return response;
	}
	

}
