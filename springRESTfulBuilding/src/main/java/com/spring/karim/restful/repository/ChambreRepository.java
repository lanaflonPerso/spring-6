package com.spring.karim.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.karim.restful.model.Chambre;



@Repository
public interface ChambreRepository extends CrudRepository<Chambre, Integer>, JpaRepository<Chambre, Integer>{

}
