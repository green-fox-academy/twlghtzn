public class Cuboid {
  public static void main(String[] args) {

    // Write a program that stores 3 sides of a cuboid as variables (doubles)
    // The program should write the surface area and volume of the cuboid like:
    //
    // Surface Area: 600
    // Volume: 1000

    double a = 3;
    double b = 4;
    double c = 2;

    int surfaceArea = (int) ((a * b) + (a * c) + (b * c));
    int volume = (int) (a * b * c);
    System.out.printf("Surface Area: " + surfaceArea + "%nVolume: " + volume);
  }
}
