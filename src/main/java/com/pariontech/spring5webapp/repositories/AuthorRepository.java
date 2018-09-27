package com.pariontech.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pariontech.spring5webapp.model.Author;

/**
 * @author oguz
 * @since 2018.9.27
 *
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
