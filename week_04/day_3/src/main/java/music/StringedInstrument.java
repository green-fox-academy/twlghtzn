package main.java.music;

public abstract class StringedInstrument extends Instrument {
  int numberOfStrings;
  String sound;

  public abstract void sound();

  public abstract void play();
}
