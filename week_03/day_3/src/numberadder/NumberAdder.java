package numberadder;

public class NumberAdder {
  // Write a recursive function that takes one parameter:
  // n and adds numbers from 1 to n.
  public static void main(String[] args) {

    System.out.println(numberAdder(55));
  }

  public static int numberAdder(int n) {
    int sum = n;
    if ((n - 1) > 0) {
      sum += numberAdder(n - 1);
      return sum;
    } else {
      return sum;
    }
  }

}
