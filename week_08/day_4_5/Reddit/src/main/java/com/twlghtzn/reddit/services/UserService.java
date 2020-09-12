package com.twlghtzn.reddit.services;

import com.twlghtzn.reddit.models.User;
import com.twlghtzn.reddit.repositories.UserRepository;
import java.util.List;
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

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public boolean isUserRegistered(String name, String password) {
    if (findUserByNameAndPassword(name, password) == null) {
      return false;
    }
    return true;
  }

  public boolean isNewUserNameAvailable(String name) {
    return userRepository.getByName(name) == null;
  }

  public User findUserByNameAndPassword(String name, String password) {
    return userRepository.getByNameAndPassword(name, password);
  }
}
