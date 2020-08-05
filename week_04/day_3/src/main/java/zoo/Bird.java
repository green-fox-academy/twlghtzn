package main.java.zoo;

import flyable.Flyable;

public class Bird extends Animal implements Flyable {

  public Bird(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public String breed() {
    return "laying eggs.";
  }

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
