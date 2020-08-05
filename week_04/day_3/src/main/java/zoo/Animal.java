package main.java.zoo;

public abstract class Animal {
  String name;
  int age;

  public String getName() {
    return name;
  }

  public abstract String breed();
}
