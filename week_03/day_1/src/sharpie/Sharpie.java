package sharpie;

public class Sharpie {
  String color;
  float width;
  float inkAmount;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  };

  public void inUse () {
    this.inkAmount -= 10;
  }

  public static void main(String[] args) {

    Sharpie green = new Sharpie("green", 3);
    green.inUse();
    System.out.println(green.color + green.inkAmount);
  }

}
