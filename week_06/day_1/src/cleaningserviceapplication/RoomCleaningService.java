package cleaningserviceapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomCleaningService {
  public List<Street> streets;

  public RoomCleaningService() {
    streets = new ArrayList<>();
  }

  public void initStreets(String[] streets) {
    Random random = new Random();
    int streetsCount = (int) (Math.random() * 5 + 1);
    while (this.streets.size() < streetsCount) {
      int street = random.nextInt(5);
      if (!this.streets.contains(streets[street])) {
        this.streets.add(new Street(streets[street], random.nextBoolean()));
      }
    }
  }

  public void reportStatus() {
    for (Street street : streets) {
      System.out.println(street.getName() + " street is closed: " + street.getIsClosed());
      for (House house : street.houses) {
        System.out.println(house.getOwner() + "'s house has a permission to clean: " +
            house.getPermission());
        for (Room room : house.rooms) {
          System.out.println(room.toString());
        }
      }
    }
  }

  public void clean() {
    for (Street street : streets) {
      if (!street.getIsClosed()) {
        for (House house : street.houses) {
          if (house.getPermission()) {
            for (Room room : house.rooms) {
              if (room.getDoorOpen()) {
                room.setShelvesClean(true);
                room.setBooksSorted(true);
                room.setCarpetClean(true);
                room.setTablesTidy(true);
                room.setWindowsDirty(false);
                room.setAirFresh(true);
              }
            }
          }

        }
      }

    }
  }
}
