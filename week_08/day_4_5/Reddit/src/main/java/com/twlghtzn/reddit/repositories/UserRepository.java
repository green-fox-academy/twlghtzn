package com.twlghtzn.reddit.repositories;

import com.twlghtzn.reddit.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

  User getByNameAndPassword(String name, String password);

  User getByName(String name);
}
