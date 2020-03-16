package com.spring.karim.restful.SpringRestFulBuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"io", "com"})
@EntityScan({"io", "com"})
@EnableJpaRepositories({"io", "com"})
public class SpringRestFulBuildingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestFulBuildingApplication.class, args);
	}

}
