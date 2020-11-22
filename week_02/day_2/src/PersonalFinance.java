import java.util.Arrays;

public class PersonalFinance {
  public static void main(String[] args) {

    Integer[] expenses = new Integer[] {500, 1000, 1250, 175, 800, 120};
    calculate(expenses);
  }

  public static void calculate(Integer[] expenses) {
    int sum = Arrays.stream(expenses).mapToInt(Integer::intValue).sum();
    System.out.println("We spent: " + sum);
    Arrays.sort(expenses);
    System.out.println("Greatest expense: " + expenses[expenses.length - 1]);
    System.out.println("Cheapest spending: " + expenses[0]);
    System.out.println("Average spending: " + sum / expenses.length);
  }
}
