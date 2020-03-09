package io.spring.ex4.webservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.spring.ex4.webservice.AgenceVoyage;

@Repository
public interface AgenceVoyageRepository extends CrudRepository<AgenceVoyage, Integer>, JpaRepository<AgenceVoyage, Integer>{

	@Query("SELECT ag FROM AgenceVoyage ag WHERE ag.login = :login AND ag.password = :password")
	AgenceVoyage findAgenceVoyage(@Param("login") String login, @Param("password") String password);

}
