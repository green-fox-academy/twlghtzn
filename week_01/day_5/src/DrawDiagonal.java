import java.util.Scanner;

public class DrawDiagonal {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    for (int i = 0; i < num; i++) {
      if (i == 0 || i == num - 1) {
        for (int j = 0; j < num; j++) {
          System.out.print("%");
        }
        System.out.printf("%n");
      } else {
        System.out.print("%");
        for (int m = 0; m < i - 1; m++) {
          System.out.print(" ");
        }
        System.out.print("%");
        for (int n = num - 2 - i; n > 0; n--) {
          System.out.print(" ");
        }
        System.out.print("%");
        System.out.printf("%n");
      }
    }
  }
}