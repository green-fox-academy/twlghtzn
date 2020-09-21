package com.twlghtzn.workshop.repositories;

import com.twlghtzn.workshop.models.Genre;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

  List<Genre> findAll();

  Genre findGenreByName(String name);
}
