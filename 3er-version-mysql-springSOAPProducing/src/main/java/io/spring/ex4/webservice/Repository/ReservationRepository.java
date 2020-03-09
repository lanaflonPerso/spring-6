package io.spring.ex4.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.spring.ex4.webservice.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>, JpaRepository<Reservation, Integer> {

}
