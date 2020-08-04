package gardenapplication;

public class Main {
  public static void main(String[] args) {

    Garden garden = new Garden();

    Flower yellow = new Flower("yellow");
    Flower blue = new Flower("blue");
    Tree purple = new Tree("purple");
    Tree orange = new Tree("orange");

    garden.addPlant(yellow);
    garden.addPlant(blue);
    garden.addPlant(purple);
    garden.addPlant(orange);

    garden.gardenInfo();
    garden.watering(40);
    garden.gardenInfo();
    garden.watering(70);
    garden.gardenInfo();

  }
}
