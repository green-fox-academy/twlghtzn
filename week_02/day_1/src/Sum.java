public class Sum {
  public static void main(String[] args) {

    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers from zero to the given parameter

    int to = 10;
    int sum = sum(to);
  }

  private static int sum(int to) {
    int sum = 0;
    for (int i = 1; i < 10; i++) {
      sum += i;
    }
    System.out.println(sum);
    return sum;
  }
}