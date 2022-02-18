package com.example.tuukankirjakauppa;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tuukankirjakauppa.domain.Book;
import com.example.tuukankirjakauppa.domain.BookRepository;


@SpringBootApplication
public class TuukankirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(TuukankirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TuukankirjakauppaApplication.class, args);
	}
	
	 @Bean
	 public CommandLineRunner demo(BookRepository repository) {
		 return (args) -> {
			 log.info("save a couple of books");
			 
			 repository.save(new Book("Book", "Author", 2020, "1234", 30.00));
			 repository.save(new Book("Book2", "Author2", 2021, "123456", 30.00));
		 };
	 }

}
