package farm;

public class Animal {
  String name;
  int hunger = 50;
  int thirst = 50;

  public Animal(String name) {
    this.name = name;
  }

  public static void isEating(Animal a) {
    a.hunger--;
  }

  public static void isDrinking(Animal a) {
    a.thirst--;
  }

  public static void isPlaying(Animal a) {
    a.hunger++;
    a.thirst++;
  }


}