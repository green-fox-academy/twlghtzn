package cleaningserviceapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Street {
  public List<House> houses;
  private String name;
  private boolean isClosed;

  public Street(String name, boolean isClosed) {
    this.name = name;
    this.isClosed = isClosed;
    houses = new ArrayList<>();
  }

  public void initHouses(String[] owners) {
    Random random = new Random();
    int housesCount = (int) (Math.random() * 5 + 1);
    while (this.houses.size() < housesCount) {
      int owner = random.nextInt(10);
      if (!this.houses.contains(owners[owner])) {
        this.houses.add(new House(owners[owner], random.nextBoolean()));
      }
    }
  }

  public String getName() {
    return name;
  }

  public boolean getIsClosed() {
    return isClosed;
  }
}
