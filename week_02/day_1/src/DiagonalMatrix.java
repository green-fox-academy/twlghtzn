import java.util.Arrays;

public class DiagonalMatrix {
  public static void main(String[] args) {
    // - Create (dynamically) a two dimensional array
    //   with the following matrix. Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    // - Print this two dimensional array to the output

    int length = 4;
    int[][] matrix = new int[length][length];

    for (int i = 0; i < length; i ++) {
      for (int j = 0; j < length; j++) {
        if (j == i) {
          matrix[i][j] = 1;
          System.out.print(matrix[i][j] + " ");
        } else {
          matrix[i][j] = 0;
          System.out.print(matrix[i][j] + " ");
        }
      }
      System.out.printf("%n");
    }
  }
}
