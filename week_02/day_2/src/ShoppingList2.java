import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingList2 {
  public static void main(String[] args) {

    Map<String, Integer> bob = Stream.of(new Object[][] {
        {"Milk", 3},
        {"Rice", 2},
        {"Eggs", 2},
        {"Cheese", 1},
        {"Chicken Breast", 4},
        {"Apples", 1},
        {"Tomato", 2},
        {"Potato", 1}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    Map<String, Integer> alice = Stream.of(new Object[][] {
        {"Rice", 1},
        {"Eggs", 5},
        {"Chicken Breast", 2},
        {"Apples", 1},
        {"Tomato", 10}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    System.out.println("Bob pays: " + String.format("%.2f", sumShoppingList(bob)));
    System.out.println("Alice pays: " + String.format("%.2f", sumShoppingList(alice)));
    System.out.println("Who buys more Rice? " + whoBuysMore(bob, alice, "Rice"));
    System.out.println("Who buys more Potato? " + whoBuysMore(bob, alice, "Potato"));
    System.out
        .println("Who buys more different products? " + whoBuysMoreDifferentProducts(bob, alice));
    System.out.println("Who buys more products? " + whoBuysMoreProducts(bob, alice));
  }

  public static String whoBuysMoreProducts(Map<String, Integer> bob,
                                           Map<String, Integer> alice) {

    int sum1 = 0;
    for (Map.Entry<String, Integer> entry : bob.entrySet()) {
      sum1 += entry.getValue();
    }
    int sum2 = 0;
    for (Map.Entry<String, Integer> entry : alice.entrySet()) {
      sum2 += entry.getValue();
    }
    if (sum1 > sum2) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static String whoBuysMoreDifferentProducts(Map<String, Integer> bob,
                                                    Map<String, Integer> alice) {

    if (bob.size() > alice.size()) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static String whoBuysMore(Map<String, Integer> bob,
                                   Map<String, Integer> alice, String product) {

    int value1 = 0;
    for (Map.Entry<String, Integer> entry : bob.entrySet()) {
      if (entry.getKey().equals(product)) {
        value1 = entry.getValue();
      }
    }
    int value2 = 0;
    for (Map.Entry<String, Integer> entry : alice.entrySet()) {
      if (entry.getKey().equals(product)) {
        value2 = entry.getValue();
      }
    }
    if (value1 > value2) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static float sumShoppingList(Map<String, Integer> shoppingList) {

    float sum = 0F;
    for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
      sum += calculatePrice(entry.getKey(), entry.getValue());
    }
    return sum;
  }

  public static double calculatePrice(String name, int amount) {

    Map<String, Double> priceList = Stream.of(new Object[][] {
        {"Milk", 1.07},
        {"Rice", 1.59},
        {"Eggs", 3.14},
        {"Cheese", 12.60},
        {"Chicken Breast", 9.40},
        {"Apples", 2.31},
        {"Tomato", 2.58},
        {"Potato", 1.75},
        {"Onion", 1.10}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Double) data[1]));

    Double value = 0D;
    for (Map.Entry<String, Double> entry : priceList.entrySet()) {
      if (entry.getKey().equals(name)) {
        value = entry.getValue();
      }
    }
    return value * amount;
  }
}
