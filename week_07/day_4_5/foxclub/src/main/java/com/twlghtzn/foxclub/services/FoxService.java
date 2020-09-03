package com.twlghtzn.foxclub.services;

import com.twlghtzn.foxclub.models.Fox;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {
  private List<Fox> foxes;

  @Autowired
  public FoxService(List<Fox> foxes) {
    this.foxes = foxes;
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void addFox() {
    foxes.add(0, new Fox());
  }

  public Fox findFox(String name) {
    for (Fox fox : foxes) {
      if (fox.getName().equals(name)) {
        return fox;
      }
    }
    return null;
  }
}
