public class ReverseString {
  public static void main(String... args) {

    String toBeReversed =
        ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a method that can reverse a String, which is passed as the parameter
    // Use it on this reversed string to check it!
    // Try to solve this using charAt() first, and optionally anything else after.

    System.out.println(reverse1(toBeReversed));
    System.out.println(reverse2(toBeReversed));
  }

  public static String reverse1(String toBeReversed) {
    StringBuilder reversed = new StringBuilder();
    for (int i = toBeReversed.length() - 1; i > -1; i--) {
      reversed.append(toBeReversed.charAt(i));
    }
    return reversed.toString();
  }

  public static String reverse2(String toBeReversed) {
    StringBuilder reversed = new StringBuilder();
    reversed.append(toBeReversed);
    reversed.reverse();
    return reversed.toString();
  }
}