package com.pariontech.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pariontech.spring5webapp.model.Publisher;

/**
 * @author oguz
 * @since 2018.9.28
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
