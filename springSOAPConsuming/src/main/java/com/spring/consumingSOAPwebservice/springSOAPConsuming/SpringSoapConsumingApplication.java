package com.spring.consumingSOAPwebservice.springSOAPConsuming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;


@SpringBootApplication
@ComponentScan({"io", "com"})
public class SpringSoapConsumingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapConsumingApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(HotelClient quoteClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	        country = args[0];
	      }
	      Client client = new Client();
	    	client.setId(13);
	    	client.setNom("Barry");
	    	client.setPrenom("Theirno");
	    	client.setCarteCredit("5088734328394382");
	      ReservationResponse response = quoteClient.getReservation("karim", "dahdouh", "50-4838493", client);
	      for(String r : response.getConfirmation())
	      System.err.println("########################################"+ r);
	    };
	  }
	  
	  

}
