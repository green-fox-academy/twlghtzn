package countletters;

import java.util.HashMap;

public class CountLetters {

  public static void main(String[] args) {

    String b = "Ezkésztéboly";
    String a = "AAaaBBbbCCcc12345";


    HashMap dictionary = countLetters(a);
    System.out.println(dictionary.keySet().toString());
    System.out.println(dictionary.values().toString());
  }

  public static HashMap countLetters(String a) {
    HashMap dictionary = new HashMap();
    for (int i = 0; i < a.length(); i++) {
      if (!dictionary.containsKey(a.charAt(i))) {
        dictionary.put(a.charAt(i), 1);
      } else {
        dictionary.put(a.charAt(i), (int) dictionary.get(a.charAt(i)) + 1);
      }
    }
    return dictionary;
  }


}
