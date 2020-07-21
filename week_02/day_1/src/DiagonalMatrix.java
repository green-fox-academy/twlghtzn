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

    int[][] anArray = new int[4][4];
    for (int i = 0; i < anArray.length; i++) {
      for (int j = 0; j < anArray.length; j++) {
        if (i == j) {
          anArray[i][j] = 1;
        } else {
          anArray[i][j] = 0;
        }
      }
    }
    for (int[] ints : anArray) {
      System.out.println(Arrays.toString(ints));
    }
  }
}
