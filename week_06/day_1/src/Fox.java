import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Fox {
  private String name;
  private String color;
  private int age;

  public Fox(String name, String color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public int getAge() {
    return age;
  }

  public static void main(String[] args) {
    List<Fox> foxes = new ArrayList<>();
    foxes.add(new Fox("Joe", "red", 1));
    foxes.add(new Fox("Jack", "green", 7));
    foxes.add(new Fox("James", "white", 3));
    foxes.add(new Fox("John", "red", 6));
    foxes.add(new Fox("Jonah", "green", 4));

    foxes.stream()
        .filter(fox -> fox.getColor().equals("green"))
        .collect(Collectors.toList())
        .forEach(fox -> System.out.println(fox.getName()));

    foxes.stream()
        .filter(fox -> fox.getColor().equals("green") && fox.getAge() < 5)
        .collect(Collectors.toList())
        .forEach(fox -> System.out.println(fox.getName()));

    Map<Object, Long> foxesCountByColor = foxes.stream()
        .collect(Collectors.groupingBy(fox -> fox.getColor(), Collectors.counting()));

    foxesCountByColor.forEach((k, v) -> System.out.println(k + ":" + v));


  }
}
