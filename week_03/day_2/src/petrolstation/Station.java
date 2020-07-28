package petrolstation;

public class Station {
  int gasAmount;

  public Station() {
    this.gasAmount = 300;
  }

  public void refill(Car car) {
    this.gasAmount = this.gasAmount - car.capacity;
    car.gasAmount = car.gasAmount + car.capacity;
  }
}
