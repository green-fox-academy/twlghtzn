import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of girls?");
        int girlsCount = scanner.nextInt();
        System.out.println("Number of boys?");
        int boysCount = scanner.nextInt();

        int guestCount = boysCount + girlsCount;

        if (boysCount == girlsCount && guestCount >= 20) {
            System.out.println("The party is excellent!");
        } else if (girlsCount != boysCount && guestCount >= 20 && girlsCount != 0) {
            System.out.println("Quite cool Party!");
        } else if (guestCount < 20 && girlsCount > 0) {
            System.out.println("Average party...");
        } else if (girlsCount == 0){
            System.out.println("Sausage party");
        }
    }
}
