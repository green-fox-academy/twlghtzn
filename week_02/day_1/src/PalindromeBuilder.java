public class PalindromeBuilder {

  public static void main(String[] args) {
    System.out.println(buildPalindrome("dog"));
  }

  public static String buildPalindrome(String word) {
    StringBuilder result =  new StringBuilder();
    result.append(word);
    for (int i = word.length() - 1; i > -1; i--) {
      result.append(word.charAt(i));
    }
    return result.toString();
  }
}
