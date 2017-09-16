package com.home.spring5webapp.model.repositories;

import com.home.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
