import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {
    System.out.println("Please enter first number:");
    Scanner scanner = new Scanner(System.in);
    int number1 = scanner.nextInt();
    System.out.println("Please enter second number:");
    int number2 = scanner.nextInt();

    if (number2 <= number1) {
      System.out.println("The second number should be bigger");
    } else {
      while (number1 < number2) {
        System.out.println(number1);
        number1 += 1;
      }
    }
  }
}
