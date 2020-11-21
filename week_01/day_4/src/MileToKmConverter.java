import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {

    // Write a program that asks for a double that is a distance in miles,
    // then it converts that value to kilometers and prints it

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter distance in miles:");
    double miles = scanner.nextDouble();
    double kms = miles * 1.60934;
    System.out.println(miles + " miles are " + kms + " kms");
  }
}
