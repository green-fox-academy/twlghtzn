import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input,
    // Then prints "Odd" if the number is odd, or "Even" if it is even.

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    String type = "Odd";
    if (number % 2 == 0) {
      type = "Even";
    }
    System.out.println(type);
  }
}
