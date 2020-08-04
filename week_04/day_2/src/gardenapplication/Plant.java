package gardenapplication;

public class Plant {
  String color;
  float waterAmount;
  boolean needsWater;
  double wateringEfficiency;

  public Plant(String color) {
    this.color = color;
    this.waterAmount = 0;
  }
}
