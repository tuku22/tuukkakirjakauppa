package com.example.tuukankirjakauppa;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tuukankirjakauppa.domain.Book;
import com.example.tuukankirjakauppa.domain.BookRepository;
import com.example.tuukankirjakauppa.domain.Category;
import com.example.tuukankirjakauppa.domain.CategoryRepository;
import com.example.tuukankirjakauppa.domain.User;
import com.example.tuukankirjakauppa.domain.UserRepository;


@SpringBootApplication
public class TuukankirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(TuukankirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TuukankirjakauppaApplication.class, args);
	}
	
	 @Bean
	 public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		 return (args) -> {
			 log.info("save a couple of books");
			 crepository.save(new Category( "Horror"));
			 crepository.save(new Category( "Sci-fi"));
			 
			 
			 repository.save(new Book("Book", "Author", 2020, "1234", 30.00, crepository.findByName("Sci-fi").get(0)));
			 
			 User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	            User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
	            urepository.save(user1);
	            urepository.save(user2);
			 
			 
			 log.info("fetch all books");
			 for(Book book : repository.findAll()) {
				 log.info(book.toString());
			 }
		 };
	 }

}
