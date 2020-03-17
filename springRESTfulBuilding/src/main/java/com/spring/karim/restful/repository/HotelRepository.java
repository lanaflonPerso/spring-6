package com.spring.karim.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.karim.restful.model.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer>, JpaRepository<Hotel, Integer>{

	@Query("SELECT h FROM Hotel h WHERE h.id = :id")
	Hotel findHotel(@Param("id") int id);
	
	@Query("SELECT h FROM Hotel h")
	List<Hotel> getAllHotels();
	
}
