import java.util.Scanner;

public class AnimalsAndLegs {
  public static void main(String[] args) {
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs owned by the farmer
    // It should print how many legs all the animals have

    System.out.println("How many chickens?");
    Scanner scanner = new Scanner(System.in);
    int numberOfChickens = scanner.nextInt();

    System.out.println("How many pigs?");
    int numberOfPigs = scanner.nextInt();

    int chickenLegs = numberOfChickens * 2;
    int pigLegs = numberOfPigs * 4;

    int sumLegs = chickenLegs + pigLegs;
    System.out.println("Sum of legs: " + sumLegs);

  }
}
