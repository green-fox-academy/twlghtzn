import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    // Write a program that asks for a number.
    // It would ask this many times to enter an integer,
    // if all the integers are entered, it should print the sum and average of these
    // integers like:
    //
    // Sum: 22, Average: 4.4

    Scanner scanner = new Scanner(System.in);
    int numberMain = scanner.nextInt();
    int counter = 1;
    int sum = 0;
    for (int i = 0; i < numberMain; i++) {
      System.out.println("Enter the " + counter + ". number!");
      int number = scanner.nextInt();
      sum += number;
      counter++;
    }
    float numberMainFloat = (float) numberMain;
    float average = sum / numberMainFloat;
    String strAverage = String.format("%.1f", average);
    System.out.println("Sum: " + sum + ", Average: " + strAverage);
  }
}
