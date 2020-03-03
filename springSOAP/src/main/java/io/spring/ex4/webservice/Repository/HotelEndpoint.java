package io.spring.ex4.webservice.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.ex4.webservice.GetHotelResponse;
import io.spring.ex4.webservice.GetHoteleRequest;


public class HotelEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/ex4/webservice";

	private HotelRepository hotelRepository;

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
	@ResponsePayload
	public GetHotelResponse getCountry(@RequestPayload GetHoteleRequest request) {
		GetHotelResponse response = new GetHotelResponse();
		response.setHotel(hotelRepository.findHotel(request.getNom()));

		return response;
	}

}
