package com.spring.consumingSOAPwebservice.springSOAPConsuming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.spring.client.HotelClient;

@Configuration
public class HotelConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.spring.consumingSOAPwebservice.wsdl");
    return marshaller;
  }

  @Bean
  @Primary
  public HotelClient countryClient(Jaxb2Marshaller marshaller) {
    HotelClient client = new HotelClient();
    client.setDefaultUri("https://springsoapproducing.cfapps.io/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}