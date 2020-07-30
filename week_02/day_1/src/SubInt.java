import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    int a = 2;
    int[] anArray = {21, 33, 42, 5, 67, 83, 24};
    int[] returnArray = searchTheArray(a, anArray);
    System.out.println(Arrays.toString(returnArray));
  }

  public static int[] searchTheArray(int a, int[] anArray) {
    String b = Integer.toString(a);
    int counter = 0;
    int[] c = new int[0];
    for (int i = 0; i < anArray.length; i++) {
      if (Integer.toString(anArray[i]).contains(b)) {
        counter++;
      }
    }
    c = new int[counter];
    int indicesCounter = 0;
    for (int i = 0; i < anArray.length; i++) {
        if (Integer.toString(anArray[i]).contains(b)) {
          c[indicesCounter] = i;
          indicesCounter++;
        }
      }
    return c;
  }
}

