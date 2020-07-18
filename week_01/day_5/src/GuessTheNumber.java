import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberToGuess = scanner.nextInt();

    System.out.println("Your guess?");
    int guess = scanner.nextInt();

    while (numberToGuess != guess)
      if (numberToGuess > guess) {
        System.out.println("The stored number is higher");
        System.out.println("Your guess?");
        guess = scanner.nextInt();
      } else if (numberToGuess < guess) {
        System.out.println("The stored number is lower");
        System.out.println("Your guess?");
        guess = scanner.nextInt();
      }

      if (numberToGuess == guess) {
        System.out.println("You found the number: " + numberToGuess);
      }
  }
}


