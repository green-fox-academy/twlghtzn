import java.util.Arrays;

public class ShoppingList {
  public static void main(String[] args) {

    String[] shoppingList = new String[] {"eggs", "milk", "fish", "apples", "bread", "chicken"};
    System.out.println(Arrays.asList(shoppingList).contains("milk"));
    System.out.println(Arrays.asList(shoppingList).contains("bananas"));
  }
}
