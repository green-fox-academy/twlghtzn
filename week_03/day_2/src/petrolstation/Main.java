package petrolstation;

public class Main {
  public static void main(String[] args) {

    Car opel = new Car();
    System.out.println(opel.gasAmount);
    Station shell = new Station();
    System.out.println(shell.gasAmount);

    shell.refill(opel);

    System.out.println(opel.gasAmount);
    System.out.println(shell.gasAmount);
  }
}
