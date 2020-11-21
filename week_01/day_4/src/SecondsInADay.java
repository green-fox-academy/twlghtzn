public class SecondsInADay {
  public static void main(String[] args) {

    int currentHours = 14;
    int currentMinutes = 34;
    int currentSeconds = 42;

    // Write a program that prints the remaining seconds (as an integer) from a
    // day if the current time is represented by the variables

    int currentHoursS = currentHours * 60 * 60;
    int currentMinutesS = currentMinutes * 60;
    int currentNowS = currentHoursS + currentMinutesS + currentSeconds;
    System.out.println(currentNowS);
    System.out.println((24 * 60 * 60) - currentNowS);
  }
}
