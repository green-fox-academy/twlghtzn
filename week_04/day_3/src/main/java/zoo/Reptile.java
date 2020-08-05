package main.java.zoo;

public class Reptile extends Animal {

  public Reptile(String name) {
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
}
