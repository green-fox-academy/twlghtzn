import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // pyramid like this:
    //
    //
    //    *
    //   ***
    //  *****
    // *******
    //
    // The pyramid should have as many lines as the number was

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    String asterisk = "*";
    String space = "";
    for (int i = 0; i < number; i++) {
      for (int j = (number / 2) - i; j > 0; j--) {
        space = space + " ";
      }
      System.out.println(space + asterisk);
      asterisk = asterisk + "*";
    }
  }
}

