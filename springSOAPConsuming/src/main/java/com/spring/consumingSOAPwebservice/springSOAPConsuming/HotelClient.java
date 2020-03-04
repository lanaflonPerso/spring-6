package com.spring.consumingSOAPwebservice.springSOAPConsuming;

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

import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;


@Service
public class HotelClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

  public GetHotelResponse getHotel(String nom, String dateDepart, 
		  String dateArrivee, String IntervellePrix, int nombreEtoiles, int nombrePersonnesHeberges) throws DatatypeConfigurationException {

    GetHotelRequest request = new GetHotelRequest();
    request.setNom("Montpellier");
 
    GregorianCalendar dd = new GregorianCalendar();
    dd.setTime(new Date("2020-02-19"));
    XMLGregorianCalendar xgdd = DatatypeFactory.newInstance().newXMLGregorianCalendar(dd);    
    request.setDateDepart(xgdd);
    
    GregorianCalendar da = new GregorianCalendar();
    da.setTime(new Date("2020-02-24"));
    XMLGregorianCalendar xgda = DatatypeFactory.newInstance().newXMLGregorianCalendar(da);    
    request.setDateArrivee(xgda);
    
    request.setIntervallePrix("10.00-60.50");
    request.setNombreEtoiles(3);
    request.setNombrePersonnesHeberges(1);
    
    log.info("Hotel requested : " + nom);

    GetHotelResponse response = (GetHotelResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/hotel", request,
            new SoapActionCallback("http://spring.io/ex4/webservice/GetHotelRequest"));

    return response;
  }

}