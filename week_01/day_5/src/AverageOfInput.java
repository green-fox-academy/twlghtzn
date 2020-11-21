import java.util.Scanner;

public class AverageOfInput {
  public static void main(String[] args) {

    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4

    Scanner scanner = new Scanner(System.in);
    int numbersCount = 5;
    float sum = 0;
    for (int i = 0; i < numbersCount; i++) {
      System.out.println("Number " + (i + 1) + "?");
      sum += scanner.nextInt();
    }

    System.out.println("Sum: " + String.format("%.0f", sum) + ", Average: " +
        String.format("%.1f", sum / numbersCount));
  }
}
