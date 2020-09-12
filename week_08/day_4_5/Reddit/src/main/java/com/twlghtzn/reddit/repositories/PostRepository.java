package com.twlghtzn.reddit.repositories;

import com.twlghtzn.reddit.models.Post;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

  List<Post> findAll();

  List<Post> findAll(Pageable pageable);
}
