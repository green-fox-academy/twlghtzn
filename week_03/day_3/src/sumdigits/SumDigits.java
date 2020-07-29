package sumdigits;

public class SumDigits {
  // Given a non-negative integer n, return the sum
  // of its digits recursively (without loops).
  public static void main(String[] args) {
    System.out.println(sumDigits(658));
  }
  public static int sumDigits(int n) {
    int sum = n%10;
    if (n > 9) {
      sum += sumDigits(n / 10);
      return sum;
    } else {
      return sum;
    }
  }
}
