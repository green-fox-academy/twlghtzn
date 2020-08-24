package main.java.music;

public class Violin extends StringedInstrument {

  public Violin() {
    this.numberOfStrings = 4;
    this.sound = "Screech";
  }

  public Violin(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    this.sound = "Screech";
  }

  @Override
  public void sound() {
    System.out.println(getClass().getSimpleName() + ", a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }

  @Override
  public void play() {
    sound();
  }
}
