package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@ComponentScan(basePackages={"com"})
public class SpringbootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStartApplication.class, args);
	}

}
