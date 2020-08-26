package reservations;

public class RandomString {

  static String getAlphaNumericString() {

    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
    StringBuilder sb = new StringBuilder(8);

    for (int i = 0; i < 8; i++) {
      int index = (int) (AlphaNumericString.length() * Math.random());
      sb.append(AlphaNumericString.charAt(index));
    }
    return sb.toString();
  }
}
