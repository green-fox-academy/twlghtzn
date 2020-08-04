package gardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  List<Plant> plants;

  public Garden() {
    this.plants = new ArrayList<>();
  }

  public void addPlant(Plant newPlant) {
    this.plants.add(newPlant);
  }

  public void watering(float wateringAmount) {
    int needsWaterCounter = 0;
    for (Plant plant: plants) {
      if (plant.needsWater) {
        needsWaterCounter++;
      }
    }
    for (Plant plant: plants) {
      if (plant.needsWater) {
        plant.waterAmount += (wateringAmount / needsWaterCounter) * plant.wateringEfficiency;
        plant.needsWater = (plant.waterAmount < 5);
      }
    }
    System.out.println("Watering with " + (int) wateringAmount);
  }

  public void gardenInfo() {
    for (Plant plant: plants) {
      if (plant.needsWater) {
        System.out.println("The " + plant.color + " " + plant.getClass().getSimpleName() + " needs water.");
      } else {
        System.out.println("The " + plant.color + " " + plant.getClass().getSimpleName() + " doesn't need water.");
      }
    }
  }
}
