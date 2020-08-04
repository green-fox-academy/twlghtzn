package gardenapplication;

public class Flower extends Plant {

  public Flower(String color) {
    super(color);
    this.wateringEfficiency = 0.75;
    this.needsWater = (waterAmount < 5);
  }

}
