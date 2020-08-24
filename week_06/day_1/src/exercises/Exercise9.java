package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise9 {
  public static void main(String[] args) {
    String givenString = "Hello";
    List<Character> charsInString = new ArrayList<>();
    for (int i = 0; i < givenString.length(); i++) {
      charsInString.add((Character) givenString.charAt(i));
    }

    Map<Character, Long> result = charsInString.stream()
        .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

    result.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}
