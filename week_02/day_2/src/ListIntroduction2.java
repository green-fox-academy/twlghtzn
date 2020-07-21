import java.util.ArrayList;
import java.util.Collections;

public class ListIntroduction2 {
  public static void main(String[] args) {
    // Create a list ('List A') which contains the following values
    //Apple, Avocado, Blueberries, Durian, Lychee
    ArrayList<String> ListA = new ArrayList<>();
    String[] toListA = {"Apple", "Avocado", "Blueberries", "Durian", "Lychee"};
    Collections.addAll(ListA, toListA);
    //Create a new list ('List B') with the values of List A
    ArrayList<String> ListB = new ArrayList<>();
    ListB.addAll(0, ListA);
    //Print out whether List A contains Durian or not
    System.out.println(ListA.contains("Durian"));
    //Remove Durian from List B
    ListB.remove("Durian");
    //Add Kiwifruit to List A after the 4th element
    ListA.add(4, "Kiwifruit");
    //Compare the size of List A and List B
    if (ListA.size() > ListB.size()) {
      System.out.println("ListA is bigger");
    } else {
      System.out.println("ListB is bigger");
    }
    //Get the index of Avocado from List A
    System.out.println(ListA.indexOf("Avocado"));
    //Get the index of Durian from List B
    System.out.println(ListB.indexOf("Durian"));
    //Add Passion Fruit and Pomelo to List B in a single statement
    String[] toListB = {"Passion Fruit", "Pomelo"};
    Collections.addAll(ListB, toListB);
    //Print out the 3rd element from List A
    System.out.println(ListA.get(2));
  }
}
