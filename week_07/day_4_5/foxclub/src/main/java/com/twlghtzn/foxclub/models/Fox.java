package com.twlghtzn.foxclub.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fox {
  private String name;
  private final List<Trick> learnedTricks;
  private String food;
  private String drink;

  @Autowired
  public Fox() {
    this.learnedTricks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Trick> getLearnedTricks() {
    return learnedTricks;
  }

  public void addToLearnedTricks(Trick newTrick) {
    this.learnedTricks.add(newTrick);
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }
}
