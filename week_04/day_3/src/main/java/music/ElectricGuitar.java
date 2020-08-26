package main.java.music;

public class ElectricGuitar extends StringedInstrument {

  public ElectricGuitar() {
    this.numberOfStrings = 6;
    this.sound = "Twang";
  }

  public ElectricGuitar(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    this.sound = "Twangg";
  }

  @Override
  public void sound() {
    System.out.println(
        getClass().getSimpleName() + ", a " + numberOfStrings + "-stringed instrument that goes " +
            sound);
  }

  @Override
  public void play() {
    sound();
  }
}
