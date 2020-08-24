package cleaningserviceapplication;

import java.util.Arrays;
import java.util.List;

public class Exercise7 {
  public static void main(String[] args) {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA",
        "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

    cities.stream()
        .filter(string -> string.startsWith("A"))
        .forEach(System.out::println);
  }
}
