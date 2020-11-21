import java.util.Scanner;

public class OneTwoALot {
  public static void main(String[] args) {

    // Write a program that reads a number form the standard input,
    // If the number is zero or smaller it should print: Not enough
    // If the number is one it should print: One
    // If the number is two it should print: Two
    // If the number is more than two it should print: A lot

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    String toPrint;
    if (number <= 0) {
      toPrint = "Not enough";
    } else if (number == 1) {
      toPrint = "One";
    } else if (number == 2) {
      toPrint = "Two";
    } else {
      toPrint = "A lot";
    }
    System.out.println(toPrint);
  }
}
