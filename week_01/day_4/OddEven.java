import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double userInput = scanner.nextDouble();
        if (userInput % 2 == 0) {
            System.out.println(userInput + " is even");
        } else {
            System.out.println(userInput + " is odd" +
                    "");
        }
    }
}
