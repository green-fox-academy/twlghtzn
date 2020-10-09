package com.twlghtzn.week00project.repositories;

import com.twlghtzn.week00project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findUserByUserName(String userName);
}
