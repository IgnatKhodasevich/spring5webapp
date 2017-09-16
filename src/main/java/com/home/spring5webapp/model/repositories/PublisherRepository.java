package com.home.spring5webapp.model.repositories;

import com.home.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ignat on 16.09.17.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
