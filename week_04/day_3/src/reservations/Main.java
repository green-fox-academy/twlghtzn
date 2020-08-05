package reservations;

public class Main {
  public static void main(String[] args) {

    Reservation reservation = new Reservation();

    String[][] reservations = reservation.fillReservationsList(10);

    Reservation.printReservations(reservations);

  }
}
