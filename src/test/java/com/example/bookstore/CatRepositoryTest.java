package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
class CatRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByTitleShouldReturnCategory() {
		List<Category> category = repository.findByName("Fiktio");
		assertThat(category).hasSize(1);
		assertThat(category.get(0).getBooks()).allMatch(null, "Fahrenheit 451");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Seikkailu");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}

}
