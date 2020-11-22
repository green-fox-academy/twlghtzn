public class ToDo {
  public static void main(String... args) {

    // Add "My t.odo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected output:

    // My t.odo:
    //  - Buy milk
    //  - Download games
    //      - Diablo

    String todoText = " - Buy milk\n";
    todoText = "My todo:\n" + todoText + " - Download\n" + "    - Diablo";
    System.out.println(todoText);
  }
}