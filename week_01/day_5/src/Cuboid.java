public class Cuboid {
  public static void main(String[] args) {
  // Write a program that stores 3 sides of a cuboid as variables (doubles)
  // The program should write the surface area and volume of the cuboid like:
  //
  // Surface Area: 600
  // Volume: 1000

    double sideA = 8;
    double sideB = 3;
    double sideC = 6;

    double surface = ((sideA * sideB) + (sideB * sideC) + (sideA * sideC)) *2;
    int surfaceInt = (int) surface;
    System.out.println("Surface Area: " + surfaceInt);

    double volume = sideA * sideB * sideC;
    int volumeInt = (int) volume;
    System.out.println("Volume: " + volumeInt);


  }
}
