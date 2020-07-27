package animal;

public class Animal {
    int hunger = 50;
    int thirst = 50;

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

  public static void main(String[] args) {
    Animal zebra = new Animal();
    isEating(zebra);
    isDrinking(zebra);
    isPlaying(zebra);
    isPlaying(zebra);
    System.out.println(zebra.hunger);
    System.out.println(zebra.thirst);
  }
}
