package oldexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
  public static void main(String... args) {
    List<String> animals = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
    // Create a method called "appendA()" that adds "a" to every string in the "animals" list.
    // The parameter should be a list.

    System.out.println(appendA(animals));
  }

  public static String appendA(List<String> animals) {

    List<String> result = new ArrayList<>();
    for (String animal : animals) {
      animal += "a";
      result.add(animal);
    }
    return result.toString();
  }
}

// The output should be: "boa", "anaconda", "koala", "panda", "zebra"
