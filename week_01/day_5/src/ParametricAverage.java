import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int times = scanner.nextInt();
    float sum = 0;
    for (int i = 0; i < times; i++) {
      int num = scanner.nextInt();
      sum += num;
    }
    String sumStr = String.format("%.0f", sum);
    String avgStr = String.format("%.1f", sum / times);
    System.out.println("Sum: " + sumStr + ", Average: " + avgStr);
  }
}
