package farm;

import static farm.Animal.isEating;
import static farm.Animal.isPlaying;


import java.util.ArrayList;
import java.util.List;

public class Farm {

  public static List<Animal> initializeFarm() {
    List<Animal> animals = new ArrayList<>();
    animals.add(new Animal("horse"));
    animals.add(new Animal("monkey"));
    animals.add(new Animal("dog"));
    animals.add(new Animal("cat"));
    animals.add(new Animal("cow"));
    return animals;
  }

  public static void main(String[] args) {

    List<Animal> farmAnimals = initializeFarm();

    int animalsCount = farmAnimals.size();
    int animalsMax = 6;

    isEating(farmAnimals.get(0));
    isEating(farmAnimals.get(0));
    isEating(farmAnimals.get(0));
    isPlaying(farmAnimals.get(3));
    isPlaying(farmAnimals.get(3));
    isPlaying(farmAnimals.get(3));
    isEating(farmAnimals.get(1));
    isEating(farmAnimals.get(2));
    isEating(farmAnimals.get(4));

    breed(animalsCount, animalsMax, farmAnimals);
    slaughter(farmAnimals);

    for (int i = 0; i < farmAnimals.size(); i++) {
      System.out.println(farmAnimals.get(i).name + "/" + farmAnimals.get(i).hunger + "/" + farmAnimals.get(i).thirst);
    }
  }
  public static void breed(int animalsCount, int animalsMax, List<Animal> animals) {
    if (animalsCount < animalsMax) {
      animals.add(new Animal("zebra"));
      System.out.println("New breed: zebra");
    }
  }
  public static void slaughter(List<Animal> animals) {
    int leastHungry = 50;
    for (int i = 0; i < animals.size(); i++) {
      if (animals.get(i).hunger < leastHungry) {
        leastHungry = animals.get(i).hunger;
      }
    }
    for (int i = 0; i < animals.size(); i++) {
      if (animals.get(i).hunger == leastHungry) {
        System.out.println(animals.get(i).name + " will be slaughtered");
        animals.remove(animals.get(i));
      }
    }
  }


}
