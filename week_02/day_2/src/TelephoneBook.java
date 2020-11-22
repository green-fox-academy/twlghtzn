import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TelephoneBook {
  public static void main(String[] args) {

    Map<String, String> phonebook = Stream.of(new String[][] {
        {"William A. Lathan", "405-709-1865"},
        {"John K. Miller", "402-247-8568"},
        {"Hortensia E. Foster", "606-481-6467"},
        {"Amanda D. Newland", "319-243-5613"},
        {"Brooke P. Askew", "307-687-2982"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    find(phonebook);
  }

  public static void find(Map<String, String> phonebook) {
    String result1 = phonebook.entrySet().stream()
        .filter(x -> "John K. Miller".equals(x.getKey()))
        .map(Map.Entry::getValue)
        .collect(Collectors.joining());
    System.out.println("John K. Miller: " + result1);

    String result2 = phonebook.entrySet().stream()
        .filter(x -> "307-687-2982".equals(x.getValue()))
        .map(Map.Entry::getKey)
        .collect(Collectors.joining());
    System.out.println("307-687-2982 belongs to " + result2);

    System.out.println(
        "Do we know Chris E. Myers's phone number? " + phonebook.containsValue("Chris E. Myers"));
  }
}
