import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {

    // Write a program that asks for two numbers and prints the bigger one

    Scanner scanner = new Scanner(System.in);
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int toPrint = number1;
    if (number1 < number2) {
      toPrint = number2;
    }
    System.out.println(toPrint);
  }
}
