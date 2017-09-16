package com.home.spring5webapp.bootstrap;

import com.home.spring5webapp.model.Author;
import com.home.spring5webapp.model.Book;
import com.home.spring5webapp.model.Publisher;
import com.home.spring5webapp.model.repositories.AuthorRepository;
import com.home.spring5webapp.model.repositories.BookRepository;
import com.home.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper", "London 45-43");
        Book gameOfThrones = new Book("Game of thrones", "1212", harper);
        eric.getBooks().add(gameOfThrones);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(gameOfThrones);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Liverpool 89-32");
        Book noEjb = new Book("Java Spring", "232323", worx);
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEjb);
    }
}
