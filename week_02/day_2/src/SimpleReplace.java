public class SimpleReplace {
  public static void main(String... args) {
    String example = "In a dishwasher far far away";

    //example.replace("dishwasher", "galaxy");

    // I would like to replace "dishwasher" with "galaxy" in this example, but it has a problem.
    // Please fix it for me!
    // Expected output: In a galaxy far far away

    String result = replacer(example);
    System.out.println(result);
  }

  public static String replacer(String a) {
    String replaced = a.replace("dishwasher", "galaxy");
    return replaced;
  }
}