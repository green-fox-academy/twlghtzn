import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {
  public static void main(String[] args) {

    // Create a map where the keys are strings and the values are strings with the following initial values
    //
    //Key	Value
    //978-1-60309-452-8	A Letter to Jo
    //978-1-60309-459-7	Lupus
    //978-1-60309-444-3	Red Panda and Moon Bear
    //978-1-60309-461-0	The Lab

    Map<String, String> map = new HashMap<>();
    String[] keys =
        {"978-1-60309-452-8", "978-1-60309-459-7", "978-1-60309-444-3", "978-1-60309-461-0"};
    String[] values = {"A Letter to Jo", "Lupus", "Red Panda and Moon Bear", "The Lab"};
    for (int i = 0; i < keys.length; i++) {
      map.put(keys[i], values[i]);
    }

    //Print all the key-value pairs in the following format
    //
    //A Letter to Jo (ISBN: 978-1-60309-452-8)
    //Lupus (ISBN: 978-1-60309-459-7)
    //Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
    //The Lab (ISBN: 978-1-60309-461-0)
    map.forEach((key, value) -> System.out.println(value + " (ISBN: " + key + ")"));
    //Remove the key-value pair with key 978-1-60309-444-3
    map.remove("978-1-60309-444-3");
    //
    //Remove the key-value pair with value The Lab
    //
    String k = "";
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().equals("The Lab")) {
        k = entry.getKey();
      }
    }
    map.remove(k);
    //Add the following key-value pairs to the map
    //
    //Key	Value
    //978-1-60309-450-4	They Called Us Enemy
    //978-1-60309-453-5	Why Did We Trust Him?
    map.put("978-1-60309-450-4", "They Called Us Enemy");
    map.put("978-1-60309-453-5", "Why Did We Trust Him?");
    //Print whether there is an associated value with key 478-0-61159-424-8 or not
    //
    System.out
        .println("Is there a value at key 478-0-61159-424-8? " + map.get("478-0-61159-424-8"));
    //Print the value associated with key 978-1-60309-453-5
    System.out.println(map.get("978-1-60309-453-5"));
  }
}
