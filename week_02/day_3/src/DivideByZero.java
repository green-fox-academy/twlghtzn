import java.io.IOException;

public class DivideByZero {
  public static void main(String[] args) {
// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0
    int divider = 0;
    try {
      System.out.println(divideTen(divider));
    } catch (RuntimeException e) {
      System.out.println("fail");
    }
  }

  public static float divideTen(int a) {
    float result = 10 / a;
    return result;
  }
}
