import java.util.ArrayList;

public class ListIntroduction1 {
  public static void main(String[] args) {
    // Create an empty list which will contain names (strings)
    ArrayList<String> introduction = new ArrayList<>();
    // Print out the number of elements in the list
    System.out.println(introduction);
    // Add William to the list
    introduction.add("William");
    // Print out whether the list is empty or not
    System.out.println(introduction.isEmpty());
    // Add John to the list
    introduction.add("John");
    // Add Amanda to the list
    introduction.add("Amanda");
    // Print out the number of elements in the list
    System.out.println(introduction.size());
    // Print out the 3rd element
    System.out.println(introduction.get(2));
    // Iterate through the list and print out each name
    //William
    //John
    //Amanda
    for (String s : introduction) {
      System.out.println(s);
    }
    // Iterate through the list and print
    //1. William
    //2. John
    //3. Amanda
    int j = 1;
    for (String s : introduction) {
      System.out.println(j + ". " + s);
      j++;
    }
    // Remove the 2nd element
    introduction.remove(1);
    // Iterate through the list in a reversed order and print out each name
    //Amanda
    //William
    for (int i = introduction.size() -1; i > -1; i--) {
      System.out.println(introduction.get(i));
    }
    // Remove all elements
    introduction.clear();
  }
}
