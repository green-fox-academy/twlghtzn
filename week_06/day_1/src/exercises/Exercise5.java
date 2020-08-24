package exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise5 {
  public static void main(String[] args) {
    int[] numbers =
        {5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2};

    int sum = Arrays.stream(numbers)
        .filter(number -> number % 2 != 0)
        .sum();

    System.out.println(sum);
  }
}
