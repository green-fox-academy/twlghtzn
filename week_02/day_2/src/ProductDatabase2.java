import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDatabase2 {
  public static void main(String[] args) {

    Map<String, Integer> products = Stream.of(new Object[][] {
        {"Eggs", 200},
        {"Milk", 200},
        {"Fish", 400},
        {"Apples", 150},
        {"Bread", 50},
        {"Chicken", 550}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    getData(products);
  }

  public static void getData(Map<String, Integer> products) {

    String result1 = products.entrySet().stream()
        .filter(entry -> entry.getValue() < 201)
        .map(Map.Entry::getKey)
        .collect(Collectors.joining(", "));
    System.out.println(result1);

    Map<String, Integer> result2 = products.entrySet().stream()
        .filter(entry -> entry.getValue() > 150)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    System.out.println(result2);
  }
}
