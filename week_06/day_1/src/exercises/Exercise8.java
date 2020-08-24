package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise8 {
  public static void main(String[] args) {
    List<Character> chars = new ArrayList<Character>();
    char[] characters =
        {'e', 'z', ' ', 'k', 'é', 's', 'z', ' ', 't', 'é', 'b', 'o', 'l', 'y', '!'};
    for (int i = 0; i < characters.length; i++) {
      chars.add((Character) characters[i]);
    }

    String result = chars.stream()
        .map(Object::toString)
        .collect(Collectors.joining());

    System.out.println(result);
  }
}
