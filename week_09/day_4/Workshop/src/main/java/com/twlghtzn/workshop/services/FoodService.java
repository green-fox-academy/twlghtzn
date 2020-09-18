package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.models.DraxResponse;
import com.twlghtzn.workshop.models.Food;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
  List<Food> foods;

  @Autowired
  public FoodService() {
    foods = new ArrayList<>();
    fillFoods();
  }

  public void fillFoods() {
    foods.add(new Food("Pizza", 1, 1000));
    foods.add(new Food("Donut", 1, 600));
    foods.add(new Food("Soup", 1, 300));
    foods.add(new Food("Steak", 1, 1800));
  }

  public List<Food> getFoods() {
    return foods;
  }

  public void addFood(String name, int amount, int calorie) {
    if (!checkIfFoodIsInFoods(name)) {
      foods.add(new Food(name, amount, calorie));
    }
  }

  public DraxResponse getAddedFoodDraxResponse() {
    return new DraxResponse("Thank you, omnomnomnom...");
  }

  public DraxResponse getErrorDraxResponse() {
    return new DraxResponse("Almost... Try again, buddy!");
  }

  public DraxResponse getFoodAlreadyExistDraxResponse() {
    return new DraxResponse("I have this already, increase it's amount instead!");
  }

  public DraxResponse getFoodRemovedDraxResponse() {
    return new DraxResponse("Why are you taking it from me?!");
  }

  public DraxResponse getAmountChangedDraxResponse() {
    return new DraxResponse("It's done!");
  }

  public boolean checkIfFoodIsInFoods(String name) {
    for (Food food : foods) {
      if (food.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Food getFoodByName(String name) {
    if (checkIfFoodIsInFoods(name)) {
      for (Food food : foods) {
        if (food.getName().equals(name)) {
          return food;
        }
      }
    }
    return null;
  }

  public void removeFood(String name) {
    if (checkIfFoodIsInFoods(name)) {
      foods.remove(getFoodByName(name));
    }
  }

  public void changeFoodAmount(String name, int amount) {
    if (checkIfFoodIsInFoods(name)) {
      Food food = getFoodByName(name);
      int calPerAmount = (int) Math.round((float) food.getCalorie() / food.getAmount());
      food.setAmount(amount);
      food.setCalorie(calPerAmount * amount);
    }
  }
}
