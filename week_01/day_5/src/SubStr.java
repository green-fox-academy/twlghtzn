public class SubStr {
  public static void main(String[] args) {
    System.out.println(subStr("this is what I'm searching in", "searching"));
    System.out.println(subStr("this is what I'm searching in", "not"));
  }
  public static int subStr(String string, String substring) {
      return string.indexOf(substring);
  }
}
