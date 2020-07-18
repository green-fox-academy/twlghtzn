import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {
    // Write a program that asks for two numbers and prints the bigger one

    Scanner scanner = new Scanner(System.in);
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();

    if (number1 > number2) {
      System.out.println(number1);
    } else if (number1 < number2) {
      System.out.println(number2);
    } else {
      System.out.println("The numbers are equal.");
    }





  }
}
