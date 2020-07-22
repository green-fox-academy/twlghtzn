import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Duplicated {
  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt

    Path path1 = Paths.get("duplicated-chars.txt");
    Path path2 = Paths.get("duplicated-decrypted.txt");
    decrypt(path1, path2);
  }

  public static void decrypt(Path a, Path b) {
    try {
      String contentA = String.valueOf(Files.readAllLines(a));
      for (int i = 0; i < contentA.length() -1; i++) {
        if (contentA.charAt(i) != contentA.charAt(i + 1)) {
          String charAtI = String.valueOf(contentA.charAt(i));
          byte[] iToByte = charAtI.getBytes();
          Files.write(b, iToByte, StandardOpenOption.APPEND);
        }
      }
    } catch (Exception ignored) {

    }
  }
}
