public class Factorio {
  public static void main(String[] args) {

    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a function called `factorio`
    //   that returns it's input's factorial

    int to = 5;
    int factorial = factorio(to);
    System.out.println(factorial);
  }

  public static int factorio(int to) {
    int sum = 1;
    for (int i = 1; i < to + 1; i++) {
      sum *= i;
    }
    return sum;
  }

}
