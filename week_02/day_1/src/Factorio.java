import java.util.Scanner;

public class Factorio {
  public static void main(String[] args) {
    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a function called `factorio`
    //   that returns it's input's factorial

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number:");
    int toFactorial = scanner.nextInt();
    int factorial = factorio(toFactorial);
    System.out.println(factorial);
  }

  public static int factorio(int a) {
    int[] factorialArray = new int[a];
    for (int i = a - 1; i > -1; i--) {
      factorialArray[i] = a - i;
    }
    int factorial = 1;
    for (int i = 0; i < factorialArray.length; i++) {
      factorial = factorial * factorialArray[i];
    }
    return factorial;
  }

}
