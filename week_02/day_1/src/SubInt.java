import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    int a = 6;
    int[] anArray = {2, 3, 4, 5};
    int[] returnArray = searchTheArray(a, anArray);
    System.out.println(Arrays.toString(returnArray));
  }

  public static int[] searchTheArray(int a, int[] anArray) {
    int[] indicesArray = new int[anArray.length];
    int[] emptyArray = new int[0];
    for (int i = 0; i < anArray.length; i++) {
      indicesArray[i] = i;
    }
    for (int value : anArray) {
      if (value == a) {
        return indicesArray;
      }
    }
    return emptyArray;
  }
}
