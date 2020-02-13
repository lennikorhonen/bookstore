package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner exampleBook(BookRepository brepository, CategoryRepository crepository) {
		return(args) ->{
			crepository.save(new Category("Fiktio"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Dekkarit"));
			
			brepository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1953, 978880427, 25, crepository.findByName("Fiktio").get(0)));
			brepository.save(new Book("Pääteasema Auschwitz", "Eddy de Wind", 2020, 978880451, 30, crepository.findByName("Historia").get(0)));
		};
	}

}
 