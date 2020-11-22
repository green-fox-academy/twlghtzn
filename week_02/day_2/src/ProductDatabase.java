import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDatabase {
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
        .filter(x -> "Fish".equals(x.getKey()))
        .map(map -> map.getValue().toString())
        .collect(Collectors.joining());
    System.out.println("Fish: " + result1);

    Optional<Map.Entry<String, Integer>> result2 = products.entrySet().stream()
        .max(Map.Entry.comparingByValue());
    result2.ifPresent(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));

    Double result3 = products.entrySet().stream()
        .collect(Collectors.averagingInt(Map.Entry::getValue));
    System.out.println("Average price: " + String.format("%.0f", result3));

    long result4 = products.entrySet().stream()
        .filter(entry -> entry.getValue() < 300)
        .count();
    System.out.println("Product's price below 300: " + result4);

    Map<Object, Object> result5 = products.entrySet().stream()
        .filter(map -> map.getValue() == 125)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    System.out.println("Is there anything we can buy for exactly 125? " + !result5.isEmpty());

    Optional<Map.Entry<String, Integer>> result6 = products.entrySet().stream()
        .min(Map.Entry.comparingByValue());
    result6.ifPresent(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
  }
}
