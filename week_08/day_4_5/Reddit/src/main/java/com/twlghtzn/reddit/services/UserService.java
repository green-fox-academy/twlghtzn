package com.twlghtzn.reddit.services;

import com.twlghtzn.reddit.models.User;
import com.twlghtzn.reddit.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public void addUser(String name, String password) {
    if (isNewUserNameAvailable(name)) {
      userRepository.save(new User(name, password));
    }
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public boolean isUserRegistered(String name, String password) {
    return findUserByNameAndPassword(name, password) != null;
  }

  public boolean isNewUserNameAvailable(String name) {
    return userRepository.getByName(name) == null;
  }

  public User findUserByNameAndPassword(String name, String password) {
    return userRepository.getByNameAndPassword(name, password);
  }
}
