package oldexercises;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Range? (x-y)");
    String expression = scanner.next();
    String[] numbers = expression.split("-");
    int from = Integer.parseInt(numbers[0]);
    int to = Integer.parseInt(numbers[1]);
    Random r = new Random();
    int number = r.nextInt(((to - from) + 1) + from);
    int lives = 5;
    System.out
        .println("I've the number between " + from + "-" + to + ". You have " + lives + " lives.");
    int guess = 0;
    while (lives > 0) {
      guess = scanner.nextInt();
      if (guess > number) {
        lives--;
        System.out.println("Too high. You have " + lives + " lives left.");
      } else if (guess < number) {
        lives--;
        System.out.println("Too low. You have " + lives + " lives left.");
      } else {
        System.out.println("Congratulations. You won!");
        break;
      }
    }
  }
}
