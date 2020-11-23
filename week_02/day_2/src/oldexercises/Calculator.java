package oldexercises;

import java.util.Scanner;

public class Calculator {
  public static void main(String... args) {

    // Create a simple calculator application which reads the parameters from the prompt
    // and prints the result to the prompt.
    // It should support the following operations,
    // create a method named "calculate()":
    // +, -, *, /, % and it should support two operands.
    // The format of the expressions must be: {operation} {operand} {operand}.
    // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

    // You can use the Scanner class
    // It should work like this:

    // Start the program
    // It prints: "Please type in the expression:"
    // Waits for the user input
    // Print the result to the prompt
    // Exit

    Scanner scanner = new Scanner(System.in);
    System.out.println("Please type in the expression:");
    String expression = scanner.nextLine();
    char operation = expression.charAt(0);
    String[] numbers = expression.substring(2).split(" ");
    int operand1 = Integer.parseInt(numbers[0]);
    int operand2 = Integer.parseInt(numbers[1]);

    System.out.println(calculate(operation, operand1, operand2));
  }

  public static String calculate(char operation, float operand1, float operand2) {

    switch (operation) {
      case '+':
        return String.format("%.0f", operand1 + operand2);
      case '-':
        return String.format("%.0f", operand1 - operand2);
      case '*':
        return String.format("%.0f", operand1 * operand2);
      case '/':
        return String.format("%.10f", operand1 / operand2);
      case '%':
        return String.format("%.0f", operand1 % operand2);
      default:
        return "Incorrect expression";
    }
  }
}
