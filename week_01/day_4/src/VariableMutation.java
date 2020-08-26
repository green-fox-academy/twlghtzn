public class VariableMutation {
  public static void main(String[] args) {

    int a = 3;
    a += 10;
    System.out.println(a);

    int b = 100;
    b -= 7;
    System.out.println(b);

    int c = 44;
    c *= 2;
    System.out.println(c);

    int d = 125;
    d /= 5;
    System.out.println(d);

    int e = 8;
    e *= e;
    System.out.println(e);

    int f1 = 123;
    int f2 = 345;
    boolean f = f1 > f2;
    System.out.println("f1 bigger as f2: " + f);

    int g1 = 350;
    int g2 = 200;
    boolean g = 200 * g2 > g1;
    System.out.println("double of g2 is bigger than g1: " + g);

    int h = 135798745;
    h %= 11;
    boolean is11ADivisor = h == 0;
    System.out.println("Is 11 a divisor of h? " + is11ADivisor);

    int i1 = 10;
    int i2 = 3;
    boolean i = i2 * i2 * i2 > i1 && i1 > i2 * i2;
    System.out.println("Is i1 higher than i2 squared and smaller than i2 cubed? " + i);

    int j = 1521;
    boolean j1 = j % 3 == 0 || j % 5 == 0;
    System.out.println("Is j dividable by 3 or 5? " + j1);
  }
}
