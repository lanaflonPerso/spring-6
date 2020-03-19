package com.spring.karim.restful.repository;

public class HotelNotFoundException extends RuntimeException {

  public HotelNotFoundException(int id) {
    super("Could not find hotel " + id);
  }
}
