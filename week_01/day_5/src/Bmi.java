public class Bmi {
  public static void main(String[] args) {

    double massInKg = 81.2;
    double heightInM = 1.78;

    // Print the Body mass index (BMI) based on these values

    System.out.printf("%.2f%n", massInKg / Math.pow(heightInM, 2));

    double price = 20.2585;
    System.out.printf("Value of double up-to 2 decimals : %.2f", price);
  }
}
