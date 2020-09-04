package com.twlghtzn.foxclub.services;

import com.twlghtzn.foxclub.models.Drink;
import com.twlghtzn.foxclub.models.Food;
import com.twlghtzn.foxclub.models.Fox;
import com.twlghtzn.foxclub.models.Trick;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ThingsService {
  List<Food> foods;
  List<Drink> drinks;
  List<Trick> tricks;

  public ThingsService() {
    this.foods = new ArrayList<>();
    foods.add(new Food("lasagna"));
    foods.add(new Food("soup"));
    foods.add(new Food("salad"));
    foods.add(new Food("steak"));
    foods.add(new Food("gyros"));
    foods.add(new Food("ravioli"));
    this.drinks = new ArrayList<>();
    drinks.add(new Drink("coffee"));
    drinks.add(new Drink("soda"));
    drinks.add(new Drink("water"));
    drinks.add(new Drink("milk"));
    drinks.add(new Drink("coke"));
    drinks.add(new Drink("tea"));
    this.tricks = new ArrayList<>();
    tricks.add(new Trick("Jumping"));
    tricks.add(new Trick("Hiding"));
    tricks.add(new Trick("Running"));
    tricks.add(new Trick("Dancing"));
    tricks.add(new Trick("Drawing"));
    tricks.add(new Trick("Speaking"));
  }

  public Food getRandomFood() {
    Random random = new Random();
    return foods.get(random.nextInt(foods.size()));
  }

  public Drink getRandomDrink() {
    Random random = new Random();
    return drinks.get(random.nextInt(drinks.size()));
  }

  public Trick getRandomTrick() {
    Random random = new Random();
    return tricks.get(random.nextInt(tricks.size()));
  }

  public void setupNewFox(Fox fox) {
    fox.setFood(getRandomFood().getName());
    fox.setDrink(getRandomDrink().getName());
    fox.addToLearnedTricks(getRandomTrick());
  }

  public List<Food> getFoods() {
    return foods;
  }

  public List<Drink> getDrinks() {
    return drinks;
  }

  public List<Trick> getTricks() {
    return tricks;
  }


  public Trick findTrick(String name) {
    for (Trick trick : tricks) {
      if (trick.getName().equals(name)) {
        return trick;
      }
    }
    return null;
  }

  public List<Trick> getNewTricks(Fox fox) {
    List<Trick> newTricks = new ArrayList<>();
    for (Trick trick : tricks) {
      if (!fox.getLearnedTricks().contains(trick) && !newTricks.contains(trick)) {
        newTricks.add(trick);
      }
    }
    return newTricks;
  }
}
