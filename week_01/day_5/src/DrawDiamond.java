import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    for (int i = 1; i < num + 1; i++) {
      for (int j = num - i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print("*");
      }
      for (int m = 0; m < i -1; m++) {
        System.out.print("*");
      }
      System.out.printf("%n");
    }
    for (int i = num - 1; i > 0; i--) {
      for (int j = num - i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print("*");
      }
      for (int m = 0; m < i -1; m++) {
        System.out.print("*");
      }
      System.out.printf("%n");
    }
  }
}
