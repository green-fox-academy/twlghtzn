import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    for (int i = 1; i < num + 1; i++) {
      for (int j = num - i; j > 0; j--) {
        System.out.printf(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.printf("*");
      }
      for (int m = 0; m < i - 1; m++) {
        System.out.printf("*");
      }
      System.out.printf("%n");
    }
  }
}

