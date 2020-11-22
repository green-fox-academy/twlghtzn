import java.util.Arrays;

public class Reverse {
  public static void main(String[] args) {

    // - Create an array variable named `numbers`
    //   with the following content: `[3, 4, 5, 6, 7]`
    // - Reverse the order of the elements in `numbers`
    // - Print the elements of the reversed `numbers`

    int[] numbers = {3, 4, 5, 6, 7};
    int[] numbersReversed = {0, 0, 0, 0, 0};

    for (int i = 0; i < numbersReversed.length; i++) {
      numbersReversed[i] = numbers[numbers.length - 1 - i];
    }
    System.out.println(Arrays.toString(numbersReversed));
  }
}
