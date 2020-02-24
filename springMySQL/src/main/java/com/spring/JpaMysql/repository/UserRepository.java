package com.spring.JpaMysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.JpaMysql.model.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {

	 //@Query("FROM User WHERE name = ?1 AND email = ?2")
	 //List<User> findByNameAndEmail(String firstName, String email);
	 
	 @Query(value = "SELECT * FROM user WHERE name = :name AND email= :email", nativeQuery = true)
	 List<User> findByNameAndEmail(@Param("name") String name, @Param("email") String email);
}