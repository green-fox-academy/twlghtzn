import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        System.out.println("Please enter a number:");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            int multiplicator = i + 1;
            int result = number * multiplicator;
            System.out.println(multiplicator + " * " + number + " = " + result);
        }
    }
}
