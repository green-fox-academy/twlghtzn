package com.twlghtzn.foxclub.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fox {
  private String name;
  private List<String> learnedTricks;
  private String food;
  private String drink;

  @Autowired
  public Fox() {
    Things things = new Things();
    this.learnedTricks = new ArrayList<>();
    this.learnedTricks.add("Relaxing");
    this.food = things.getRandomFood();
    this.drink = things.getRandomDrink();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getLearnedTricks() {
    return learnedTricks;
  }

  public void addToLearnedTricks(String learnedTrick) {
    this.learnedTricks.add(learnedTrick);
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
