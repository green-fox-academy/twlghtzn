package gardenapplication;

public class Tree extends Plant {

  public Tree(String color) {
    super(color);
    this.wateringEfficiency = 0.4;
    this.needsWater = (waterAmount < 10);
  }

}
