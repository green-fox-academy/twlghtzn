import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
  public static void main(String[] args) {
    // Write a function that copies the contents of a file into another
    // It should take the filenames as parameters
    // It should return a boolean that shows if the copy was successful

    String file1 = "my-file.txt";
    String file2 = "my-otherfile.txt";
    System.out.println(contentCopier(file1, file2));
  }
  public static boolean contentCopier(String a, String b) {
    try {
      Path path1 = Paths.get(a);
      Path path2 = Paths.get(b);
      List<String> linesA = Files.readAllLines(path1);
      Files.write(path2, linesA);
      return true;
    } catch (Exception e) {
      return false;
    }

  }
}
