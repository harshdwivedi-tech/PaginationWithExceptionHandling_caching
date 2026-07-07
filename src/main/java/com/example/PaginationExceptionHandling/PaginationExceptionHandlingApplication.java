package com.example.PaginationExceptionHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PaginationExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationExceptionHandlingApplication.class, args);
	}

}
