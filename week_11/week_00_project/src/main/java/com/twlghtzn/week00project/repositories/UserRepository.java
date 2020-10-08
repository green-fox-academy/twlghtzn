package com.twlghtzn.week00project.repositories;

import com.twlghtzn.week00project.models.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findUserByUserNameAndPassword(String userName, String password);
}
