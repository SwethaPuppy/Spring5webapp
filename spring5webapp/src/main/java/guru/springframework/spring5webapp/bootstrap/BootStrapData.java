/**
 * 
 */
package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * @author sweth
 *
 * created on May 24, 2020
 */
@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setName("James Clear");
		publisher.setAddress1("9/14 ABC Street");
		publisher.setCity("Washington DC");
		publisher.setState("Michigan");
		
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric","Evans");
		Book book = new Book("Domain Driven Design","12345");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		book.setPublisher(publisher);
		publisher.getBooks().add(book);
		
		authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		Author rod = new Author("Rod", "Johnson");
		Book book1 = new Book("J2EE Development without EJB","67890");
		book1.setPublisher(publisher);
		publisher.getBooks().add(book1);
		
		authorRepository.save(rod);
		bookRepository.save(book1);
		publisherRepository.save(publisher);
		
		
		System.out.println("Publisher count:: "+publisherRepository.count());
		
		System.out.println("Bootstrap is running"+publisher.getBooks().size());
		
		System.out.println("No of books :: "+bookRepository.count());
		
	}

}
