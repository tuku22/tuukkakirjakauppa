package com.example.tuukankirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.tuukankirjakauppa.domain.Book;
import com.example.tuukankirjakauppa.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	   @RequestMapping("/add")
	    public String addBook(Model model) {
	        model.addAttribute("book", new Book());
	        return "addbook.html";
	    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value= {"/delete/{id}"}, method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	 @RequestMapping("/edit/{id}")
	    public String editBook(@PathVariable("id") Long bookId, Model model) {
		 model.addAttribute("book", repository.findById(bookId));
	        return "editbook.html";
	    }
}
	

	
	
	

