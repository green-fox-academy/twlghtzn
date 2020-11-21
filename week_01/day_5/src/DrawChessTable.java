public class DrawChessTable {
  public static void main(String[] args) {

    int num = 8;
    for (int i = 1; i < num + 1; i++) {
      if (i % 2 == 1) {
        for (int j = 0; j < num / 2; j++) {
          System.out.print("% ");
        }
      } else {
        for (int j = 0; j < num / 2; j++) {
          System.out.print(" %");
        }
      }
      System.out.printf("%n");
    }
  }
}
