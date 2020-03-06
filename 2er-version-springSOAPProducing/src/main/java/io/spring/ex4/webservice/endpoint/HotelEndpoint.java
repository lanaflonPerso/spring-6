package io.spring.ex4.webservice.endpoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.ex4.webservice.GetHotelRequest;
import io.spring.ex4.webservice.GetHotelResponse;
import io.spring.ex4.webservice.Hotel;
import io.spring.ex4.webservice.Offre;
import io.spring.ex4.webservice.ReservationRequest;
import io.spring.ex4.webservice.ReservationResponse;
import io.spring.ex4.webservice.Repository.HotelRepository;
import io.spring.ex4.webservice.Repository.ReservationRepository;


@Endpoint
public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";

	private HotelRepository hotelRepository;
	private ReservationRepository reservationRepository;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository, ReservationRepository reservationRepository) {
		this.hotelRepository = hotelRepository;
		this.reservationRepository = reservationRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
	@ResponsePayload
	public GetHotelResponse getHotel(@RequestPayload GetHotelRequest request) {
		GetHotelResponse response = new GetHotelResponse();
		offres = hotelRepository.findHotel(request.getLogin(), request.getPassword(), request.getDateDebut(), request.getDateFin(), request.getNombrePersonnesHeberges());
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
		
		confirmation = reservationRepository.confirmerReservation(request.getLogin(), request.getPassword(), request.getIdOffre(), request.getClient());
		response.getConfirmation().addAll(confirmation);
		System.out.println("la reservation de Mr. "+ request.getClient().getPrenom() + " "+ request.getClient().getNom());
		System.out.println("identifiant Offre: "+ confirmation.get(1));
		System.out.println("message de confirmation: "+ confirmation.get(0));
		
		return response;
	}

}
