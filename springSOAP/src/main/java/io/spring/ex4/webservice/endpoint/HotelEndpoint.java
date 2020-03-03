package io.spring.ex4.webservice.endpoint;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.ex4.webservice.GetHotelRequest;
import io.spring.ex4.webservice.GetHotelResponse;
import io.spring.ex4.webservice.Repository.HotelRepository;


@Endpoint
public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";

	private HotelRepository hotelRepository;

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
	@ResponsePayload
	public GetHotelResponse getCountry(@RequestPayload GetHotelRequest request) {
		GetHotelResponse response = new GetHotelResponse();
		Date dateDepart = request.getDateDepart().toGregorianCalendar().getTime();
		Date dateArrivee = request.getDateArrivee().toGregorianCalendar().getTime();
		response.setHotel(hotelRepository.findHotel(request.getNom(), dateDepart, dateArrivee, request.getIntervallePrix()));
		System.out.println("###################### ???????????????????????????????,, "+ dateDepart);
		System.out.println(" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ,, "+ dateArrivee);
		return response;
	}

}
