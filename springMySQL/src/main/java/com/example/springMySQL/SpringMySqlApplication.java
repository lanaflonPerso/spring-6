package com.example.springMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EntityScan("com")
@EnableJpaRepositories("com")
public class SpringMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlApplication.class, args);
	}

}
