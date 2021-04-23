package com.db.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.db.library.model.Author;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class LibraryApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		
	}

}
