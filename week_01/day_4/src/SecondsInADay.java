public class SecondsInADay {
  public static void main(String[] args) {
    int currentHours = 14;
    int currentMinutes = 34;
    int currentSeconds = 42;

    int secondsLeftFromTheDay =
        86400 - (currentSeconds + currentMinutes * 60 + currentHours * 3600);
    System.out.println("Remaining seconds from the day: " + secondsLeftFromTheDay + " seconds");
  }
}
