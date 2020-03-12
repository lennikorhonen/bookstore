package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner exampleBook(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return(args) ->{
			crepository.save(new Category("Fiktio"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Dekkarit"));
			
			brepository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1953, 978880427, 25, crepository.findByName("Fiktio").get(0)));
			brepository.save(new Book("Pääteasema Auschwitz", "Eddy de Wind", 2020, 978880451, 30, crepository.findByName("Historia").get(0)));
			
			User user1 = new User("user", "$2y$12$SusvugFmsbBgGdkylPfAYeRGkEdZU0wk39Nh71fPndQt1MNJMXCIi", "USER");
			User user2 = new User("admin", "$2y$12$oCn6VjnDtbnh73JtE.9O9e3t4xPV.9gJdt8rj5YuJIA5TZEYI7moO", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
 