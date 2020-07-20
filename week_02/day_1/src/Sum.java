import java.util.Scanner;

public class Sum {
  public static void main(String[] args) {
    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers from zero to the given parameter
    Scanner scanner = new Scanner(System.in);
    int start = 0;
    System.out.println("Enter a number:");
    int end = scanner.nextInt();
    int totalSum = sum(start, end);
    System.out.println(totalSum);
  }
  public static int sum(int a, int b) {
    int totalSum = 0;
    for (int i = 0; i < b + 1; i++) {
      totalSum = totalSum + a;
      a++;
    }
    return totalSum;
  }
}

