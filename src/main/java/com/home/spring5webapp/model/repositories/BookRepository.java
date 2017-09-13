package com.home.spring5webapp.model.repositories;

import com.home.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ignat on 14.09.17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
