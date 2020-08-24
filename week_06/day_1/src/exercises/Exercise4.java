package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Exercise4 {
  public static void main(String[] args) {
    int[] numbers = {1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14};

    Arrays.stream(numbers)
        .filter(number -> number % 2 == 1)
        .average()
        .ifPresent(System.out::println);
  }
}
