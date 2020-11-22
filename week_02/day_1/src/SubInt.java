import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {

    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    System.out.println(Arrays.toString(subInt(1, new int[] {1, 11, 34, 52, 61})));
    System.out.println(Arrays.toString(subInt(9, new int[] {1, 11, 34, 52, 61})));
  }

  private static int[] subInt(int number, int[] numbers) {
    int counter = 0;
    for (int element : numbers) {
      if (String.valueOf(element).contains(String.valueOf(number))) {
        counter++;
      }
    }
    int[] indexes = new int[counter];
    int indexCounter = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (String.valueOf(numbers[i]).contains(String.valueOf(number))) {
        indexes[indexCounter] = i;
        indexCounter++;
      }
    }
    return indexes;
  }
}

