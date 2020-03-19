package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Fahrenheit 451");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ray Bradbury");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Nakki", "Vene", 1999, 123456, 30, new Category("Seikkailu"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
