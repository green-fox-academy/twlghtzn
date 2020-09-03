package com.twlghtzn.foxclub.models;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Things {
  private String[] tricks;
  private String[] food;
  private String[] drink;

  public Things() {
    this.tricks = new String[]{
        "Jumping",
        "Hiding",
        "Running",
        "Dancing",
        "Drawing",
        "Speaking"
    };
    this.food = new String[]{
        "lasagna",
        "soup",
        "salad",
        "steak",
        "gyros",
        "ravioli"
    };
    this.drink = new String[]{
        "coffee",
        "soda",
        "water",
        "milk",
        "coke",
        "tea"
    };
  }

  public String getRandomTrick() {
    Random random = new Random();
    return tricks[random.nextInt(tricks.length)];
  }

  public String getRandomFood() {
    Random random = new Random();
    return food[random.nextInt(food.length)];
  }

  public String getRandomDrink() {
    Random random = new Random();
    return drink[random.nextInt(drink.length)];
  }
}
