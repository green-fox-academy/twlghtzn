package com.twlghtzn.week00project.services;

import com.twlghtzn.week00project.models.User;
import com.twlghtzn.week00project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addUser(String userName, String password) {
    userRepository.save(new User(userName, password));
  }

  public boolean areUserCredentialsValid(String userName, String password) {
    return userRepository.findUserByUserNameAndPassword(userName, password).isPresent();
  }
}
