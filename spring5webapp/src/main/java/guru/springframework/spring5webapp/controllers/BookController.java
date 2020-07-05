/**
 * 
 */
package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

/**
 * @author sweth
 *
 * created on May 25, 2020
 */
@Controller
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	@RequestMapping("/books")
	public String getBooks(Model model) {
		System.out.println("Hello");
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}
	
	@RequestMapping(value = "/index")
	   public String index() {
	      return "index";
	   }
	}
