package com.pariontech.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pariontech.spring5webapp.model.Author;
import com.pariontech.spring5webapp.model.Book;
import com.pariontech.spring5webapp.model.Publisher;
import com.pariontech.spring5webapp.repositories.AuthorRepository;
import com.pariontech.spring5webapp.repositories.BookRepository;
import com.pariontech.spring5webapp.repositories.PublisherRepository;

/**
 * @author oguz
 * @since 2018.9.27
 *
 */

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		
		// Eric
		Publisher harper = new Publisher("Harper Collins", "Çanakkale, Turkey");
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(harper);

		// Rod
		Publisher wrox = new Publisher("Wrox", "Çanakkale, Turkey");
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(wrox);
	}
}
