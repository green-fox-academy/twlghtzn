package main.java.zoo;

public class Mammal extends Animal {

  public Mammal(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public String breed() {
    return "pushing miniature versions out.";
  }
}
