import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter distance in miles: ");
    double mile = scanner.nextDouble();
    double km = mile * 1.6;
    System.out.println(mile + " miles are " + km + " kilometres");
  }
}
