package com.home.spring5webapp.bootstrap;

import com.home.spring5webapp.model.Author;
import com.home.spring5webapp.model.Book;
import com.home.spring5webapp.model.repositories.AuthorRepository;
import com.home.spring5webapp.model.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ignat on 14.09.17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author eric = new Author("Eric", "Evans");
        Book gameOfThrones = new Book("Game of thrones", "1212", "Harper");
        eric.getBooks().add(gameOfThrones);

        authorRepository.save(eric);
        bookRepository.save(gameOfThrones);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("Java Spring", "232323", "Worx");
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}
