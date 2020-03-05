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
import io.spring.ex4.webservice.Repository.HotelRepository;


@Endpoint
public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";

	private HotelRepository hotelRepository;
	private List<Offre> offres = new ArrayList<Offre>();

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
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

}
