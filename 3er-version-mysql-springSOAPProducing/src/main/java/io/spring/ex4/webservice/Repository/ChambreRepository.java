package io.spring.ex4.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Hotel;

@Repository
public interface ChambreRepository extends CrudRepository<Chambre, Integer>, JpaRepository<Chambre, Integer>{

}
