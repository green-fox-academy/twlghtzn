package com.twlghtzn.workshop.controllers;

import com.twlghtzn.workshop.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DraxController {
  private FoodService foodService;

  @Autowired
  public DraxController(FoodService foodService) {
    this.foodService = foodService;
  }

  @RequestMapping("/drax")
  public ResponseEntity showDraxCalorieTable() {
    return ResponseEntity.status(HttpStatus.OK).body(foodService.getFoods());
  }

  @RequestMapping("/drax/addfood")
  public ResponseEntity addFood(@RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "amount", required = false) Integer amount,
                                @RequestParam(name = "calorie", required = false) Integer calorie) {
    if (name != null && amount != null && calorie != null) {
      if (!foodService.checkIfFoodIsInFoods(name)) {
        foodService.addFood(name, amount, calorie);
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getAddedFoodDraxResponse());
      } else {
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getFoodAlreadyExistDraxResponse());
      }
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(foodService.getErrorDraxResponse());
    }
  }

  @RequestMapping("/drax/remove")
  public ResponseEntity removeFood(@RequestParam(name = "name", required = false) String name) {
    if (name != null) {
      if (foodService.checkIfFoodIsInFoods(name)) {
        foodService.removeFood(name);
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getFoodRemovedDraxResponse());
      } else {
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getErrorDraxResponse());
      }
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(foodService.getErrorDraxResponse());
    }
  }

  @RequestMapping("/drax/changeamount")
  public ResponseEntity changeAmount(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "amount", required = false) Integer amount) {
    if (name != null && amount != null) {
      if (foodService.checkIfFoodIsInFoods(name)) {
        foodService.changeFoodAmount(name, amount);
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getAmountChangedDraxResponse());
      } else {
        return ResponseEntity.status(HttpStatus.OK)
            .body(foodService.getErrorDraxResponse());
      }
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(foodService.getErrorDraxResponse());
    }
  }
}
