package flyable;

public class Helicopter extends Vehicle implements Flyable {

  @Override
  public void fly() {
    System.out.println(" is flying");
  }

  @Override
  public void land() {
    System.out.println(" is landing");
  }

  @Override
  public void takeOff() {
    System.out.println(" is taking off");
  }
}
