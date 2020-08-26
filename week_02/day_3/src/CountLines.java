import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountLines {
  public static void main(String[] args) {
    // Write a function that takes a filename as string,
    // then returns the number of lines the file contains.
    // It should return zero if it can't open the file, and
    // should not raise any error.

    String myFile = "my-file.txt";
    System.out.println(lineCounter(myFile));
  }

  public static long lineCounter(String fileName) {
    long linesCount = 0;
    try {
      Path path = Paths.get(fileName);
      linesCount = Files.lines(path).count();
    } catch (Exception e) {
      System.out.println("0");
    }
    return linesCount;
  }
}
