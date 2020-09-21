package com.twlghtzn.workshop.repositories;

import com.twlghtzn.workshop.models.Genre;
import com.twlghtzn.workshop.models.Song;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

  List<Song> findAll();
}
