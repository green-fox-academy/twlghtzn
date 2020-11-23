package oldexercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Matchmaking {
  public static void main(String... args) {
    ArrayList<String> girls =
        new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
    ArrayList<String> boys =
        new ArrayList<String>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

    // Write a method that joins the two lists by matching one girl with one boy into a new list
    // If someone has no pair, he/she should be the element of the list too
    // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

    System.out.println(makingMatches(girls, boys));
  }

  public static String makingMatches(ArrayList<String> girls, ArrayList<String> boys) {

    StringBuilder result = new StringBuilder();
    ArrayList<String> shorterList = girls;
    ArrayList<String> longerList = boys;
    if (girls.size() > boys.size()) {
      shorterList = boys;
      longerList = girls;
    }
    for (int i = 0; i < shorterList.size(); i++) {
      result.append(girls.get(i));
      result.append(", ");
      result.append(boys.get(i));
      result.append(", ");
    }
    for (int i = shorterList.size(); i < longerList.size(); i++) {
      result.append(longerList.get(i));
      result.append(", ");
    }
    return result.toString();
  }
}
