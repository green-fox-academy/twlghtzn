import java.util.ArrayList;
import java.util.List;

public class Anagram {
  public static void main(String[] args) {

    // Create a function named isAnagram following your current language's style guide.
    // It should take two strings and return a boolean value depending on whether its an anagram or not.

    System.out.println(isAnagram("god", "dog"));
    System.out.println(isAnagram("green", "fox"));
  }

  public static boolean isAnagram(String word1, String word2) {
    boolean result = true;
    if (word1.length() != word2.length()) {
      return false;
    } else {
      List<Character> chars1 = new ArrayList<>();
      for (int i = 0; i < word1.length(); i++) {
        chars1.add(word1.charAt(i));
      }
      List<Character> chars2 = new ArrayList<>();
      for (int i = 0; i < word2.length(); i++) {
        chars2.add(word1.charAt(i));
      }
      for (Character c : chars1) {
        if (!chars2.contains(c)) {
          result = false;
          break;
        }
      }
    }
    return result;
  }
}
