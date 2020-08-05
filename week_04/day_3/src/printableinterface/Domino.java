package printableinterface;

import java.util.List;

public class Domino implements Printable{
  int sideA;
  int sideB;

  public Domino(int toSideA, int toSideB) {
    this.sideA = toSideA;
    this.sideB = toSideB;
  }

  @Override
  public void printAllFields() {
    System.out.println("Domino A side: " + this.sideA + ", B side: " + this.sideB);
  }
}
