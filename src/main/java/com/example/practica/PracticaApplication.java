package com.example.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class PracticaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}
}
