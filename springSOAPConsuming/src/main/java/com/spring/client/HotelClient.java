package com.spring.client;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;
import com.spring.consumingSOAPwebservice.wsdl.ReservationRequest;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;


@Service
public class HotelClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(HotelClient.class);
  
  public GetHotelResponse getOffresHotel(String login, String password, String dateDebut, String dateFin, int nombrePersonHeberges) {

	    GetHotelRequest request = new GetHotelRequest();
	    request.setLogin(login);
	    request.setPassword(password);
	    request.setDateDebut(dateDebut);
	    request.setDateFin(dateFin);
	 
	    GetHotelResponse response = (GetHotelResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/hotel", request,
	            new SoapActionCallback("http://spring.io/ex4/webservice/GetHotelRequest"));

	    log.info("€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€e");
	    return response;
	  }


  public ReservationResponse doReservation(String login, String password, String idOffre, Client client) {

	    ReservationRequest request = new ReservationRequest();
	    request.setLogin(login);
	    request.setPassword(password);
	    request.setIdOffre(idOffre);
	    request.setClient(client);
	 
	    log.info("Reservation de client : " + client.getNom());

	    ReservationResponse response = (ReservationResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/reservation", request,
	            new SoapActionCallback("http://spring.io/ex4/webservice/ReservationRequest"));

	    log.info("€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€€e");
	    return response;
	  }
  
}
  
  