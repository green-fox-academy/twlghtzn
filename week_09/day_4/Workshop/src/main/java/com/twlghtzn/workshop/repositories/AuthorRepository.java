package com.twlghtzn.workshop.repositories;

import com.twlghtzn.workshop.models.Author;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

  List<Author> findAll();

  Author findAuthorByName(String name);
}
