package reservations;

public class Reservation implements Reservationy {

  public Reservation() {
  }

  @Override
  public String getDowBooking() {
    return RandomDOW.randomDOW();
  }

  @Override
  public String getCodeBooking() {
    return RandomString.getAlphaNumericString();
  }

  public String[][] fillReservationsList(int reservationsCount) {
    String[][] reservations = new String[reservationsCount][2];
    for (int i = 0; i < reservationsCount; i++) {
      reservations[i][0] = getCodeBooking();
    }
    for (int i = 0; i < reservationsCount; i++) {
        reservations[i][1] = getDowBooking();
    }
    return reservations;
  }

  public static void printReservations(String[][] reservations) {
    for (String[] reservation : reservations) {
      System.out.println("Booking# " + reservation[0] + " for " + reservation[1]);
    }
  }

}
