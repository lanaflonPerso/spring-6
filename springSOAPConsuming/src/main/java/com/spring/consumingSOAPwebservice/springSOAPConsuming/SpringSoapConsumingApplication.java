package com.spring.consumingSOAPwebservice.springSOAPConsuming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.consumingSOAPwebservice.wsdl.GetCountryResponse;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;

@SpringBootApplication
@ComponentScan({"io", "com"})
public class SpringSoapConsumingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapConsumingApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	        country = args[0];
	      }
	      GetCountryResponse response = quoteClient.getCountry(country);
	      System.err.println(response.getCountry().getCurrency());
	    };
	  }
	  */
	  

}
