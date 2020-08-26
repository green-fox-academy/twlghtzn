import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class WriteSingleLine {
  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // By writing your name into it as a single line
    // The file should be named "my-file.txt"
    // In case the program is unable to write the file,
    // It should print the following error message: "Unable to write file: my-file.txt"

    String myName = "Bor Orsolya";
    fileManipulator(myName);
  }

  public static void fileManipulator(String a) {
    try {
      Path filePath = Paths.get("my-file.txt");
      byte[] aToBytes = a.getBytes();
      Files.write(filePath, aToBytes);
    } catch (Exception e) {
      System.out.println("Unable to write file: my-file.txt");
    }
  }
}
