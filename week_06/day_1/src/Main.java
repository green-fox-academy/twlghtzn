import cleaningserviceapplication.House;
import cleaningserviceapplication.RoomCleaningService;
import cleaningserviceapplication.Street;

public class Main {
  public static void main(String[] args) {
    String[] rooms = {"living room", "kitchen", "master bedroom",
        "kid1 bedroom", "kid2 bedroom", "master bathroom", "bathroom",
        "guest room", "dining room", "library"};

    String[] owners = {"Smith", "Jackson", "Robinson", "MayWeather", "Jenkins",
        "Jetson", "Jameson", "Orwell", "Blake", "Gates"};

    String[] streets = {"Oak", "Maple", "22nd", "Union", "Hudson"};

    RoomCleaningService cleanRooms = new RoomCleaningService();
    cleanRooms.initStreets(streets);
    for (Street street : cleanRooms.streets) {
      street.initHouses(owners);
    }
    for (Street street : cleanRooms.streets) {
      for (House house : street.houses) {
        house.initRooms(rooms);
      }
    }

    cleanRooms.reportStatus();
    cleanRooms.clean();
    cleanRooms.reportStatus();
  }
}
