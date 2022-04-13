package com.example.tuukankirjakauppa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.tuukankirjakauppa.domain.Book;
import com.example.tuukankirjakauppa.domain.BookRepository;
import com.example.tuukankirjakauppa.domain.CategoryRepository;
import com.example.tuukankirjakauppa.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	 @Autowired
	 private BookRepository	 brepository;
	 private CategoryRepository crepository;
	 private UserRepository urepository;
	 
	 @Test
	 public void findByTitleShouldReturnAuthor() {
		 List<Book> books = brepository.findByTitle("Title");
		 
		 assertThat(books).hasSize(1);
		 assertThat(books.get(0).getAuthor().isEqualTo("Author");
	 }

}
