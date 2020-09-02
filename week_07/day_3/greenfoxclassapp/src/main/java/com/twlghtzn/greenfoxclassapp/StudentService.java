package com.twlghtzn.greenfoxclassapp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final List<String> names;

  @Autowired
  public StudentService() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }

  public List<String> findAll() {
    return names;
  }

  public void save(String student) {
    names.add(student);
  }

  public boolean isNameAlreadyInNames(String name) {
    for (String s : names) {
      if (s.equals(name)) {
        return true;
      }
    }
    return false;
  }
}