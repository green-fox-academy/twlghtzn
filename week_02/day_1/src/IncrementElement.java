public class IncrementElement {
  public static void main(String[] args) {
    // Ready
    // - Create an array variable named `numbers`
    //   with the following content: `[1, 2, 3, 4, 5]`
    // - Increment the third element
    // - Print the third element

    int[] numbers = {1, 2, 3, 4, 5};
    numbers[2] = numbers[2] + 5;
    System.out.println(numbers[2]);
  }
}
