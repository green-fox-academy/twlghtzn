import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    String asterisk = "*";
    for (int i = 0; i < number; i++) {
      System.out.println(asterisk);
      asterisk += "*";
    }
  }
}
