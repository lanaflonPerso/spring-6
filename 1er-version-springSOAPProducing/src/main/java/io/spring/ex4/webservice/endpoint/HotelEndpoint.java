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
import io.spring.ex4.webservice.Repository.HotelRepository;


@Endpoint
public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";

	private HotelRepository hotelRepository;
	List<Hotel> listHotel = new ArrayList<Hotel>();

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
	@ResponsePayload
	public GetHotelResponse getHotel(@RequestPayload GetHotelRequest request) {
		GetHotelResponse response = new GetHotelResponse();
		Date dateDepart = request.getDateDepart().toGregorianCalendar().getTime();
		Date dateArrivee = request.getDateArrivee().toGregorianCalendar().getTime();
		
		listHotel = hotelRepository.findHotel(request.getVille(), dateDepart, dateArrivee,request.getIntervallePrix(), request.getNombreEtoiles(), request.getNombrePersonnesHeberges());
		response.getHotel().addAll(listHotel);
		
		System.out.println("date de départ: "+ dateDepart);
		System.out.println(" date d'arrivée:  "+ dateArrivee);
		System.out.println(" interveless du prix: "+ request.getIntervallePrix());
		System.out.println(" nombre etoiles: "+ request.getNombreEtoiles());
		System.out.println(" nombre etoiles: "+ request.getNombrePersonnesHeberges());
		return response;
	}

}
