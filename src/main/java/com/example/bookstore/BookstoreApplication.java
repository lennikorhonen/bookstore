package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner exampleBook(BookRepository repository) {
		return(args) ->{
			repository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1953, 978880427, 25));
			repository.save(new Book("Pääteasema Auschwitz", "Eddy de Wind", 2020, 978880451, 30));
		};
	}

}
 