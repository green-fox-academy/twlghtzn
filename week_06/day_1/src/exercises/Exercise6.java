package exercises;

public class Exercise6 {
  public static void main(String[] args) {
    String string = "UztVB";

    string.chars()
        .filter(Character::isUpperCase)
        .forEach(character -> System.out.println((char) character));
  }
}
