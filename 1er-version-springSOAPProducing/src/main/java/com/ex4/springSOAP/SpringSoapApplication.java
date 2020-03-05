package com.ex4.springSOAP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io", "com"})
public class SpringSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapApplication.class, args);
	}

}
