import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {

    int numberToGuess = 9;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Your guess:");
    int num = scanner.nextInt();

    while (num != numberToGuess) {
      if (num < numberToGuess) {
        System.out.println("The stored number is higher");
      } else {
        System.out.println("The stored number is lower");
      }
      System.out.println("Your guess:");
      num = scanner.nextInt();
    }
    System.out.println("You found the number: " + num);
  }
}


