import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    for (int i = 1; i < num +1; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.printf("%n");
    }
  }
}
