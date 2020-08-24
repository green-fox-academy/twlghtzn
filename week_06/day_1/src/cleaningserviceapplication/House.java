package cleaningserviceapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
  public List<Room> rooms;
  private final String owner;
  private boolean permission;

  public House(String owner, boolean permission) {
    this.owner = owner;
    this.permission = permission;
    rooms = new ArrayList<>();
  }

  public void initRooms(String[] rooms) {
    Random random = new Random();
    int roomsCount = (int) (Math.random() * 5 + 1);
    while (this.rooms.size() < roomsCount) {
      int room = random.nextInt(10);
      if (!this.rooms.contains(rooms[room])) {
        this.rooms.add(new Room(rooms[room]));
      }
    }
  }

  public String getOwner() {
    return owner;
  }

  public boolean getPermission() {
    return permission;
  }
}
