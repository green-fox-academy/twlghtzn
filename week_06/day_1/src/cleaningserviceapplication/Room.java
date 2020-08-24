package cleaningserviceapplication;

import java.util.Random;

public class Room {
  private final String name;
  private boolean shelvesClean;
  private boolean booksSorted;
  private boolean carpetClean;
  private boolean tablesTidy;
  private boolean windowsDirty;
  private boolean airFresh;
  private boolean doorOpen;

  public Room(String name) {
    this.name = name;
    Random random = new Random();
    shelvesClean = random.nextBoolean();
    booksSorted = random.nextBoolean();
    carpetClean = random.nextBoolean();
    tablesTidy = random.nextBoolean();
    windowsDirty = random.nextBoolean();
    airFresh = random.nextBoolean();
    doorOpen = random.nextBoolean();
  }

  @Override
  public String toString() {
    StringBuilder roomInfo = new StringBuilder();
    roomInfo.append(name + ":\n shelves are clean: " + shelvesClean +
        ",\n books are sorted: " + booksSorted +
        ",\n carpet is clean: " + carpetClean +
        ",\n tables are tidy: " + tablesTidy +
        ",\n windows are dirty: " + windowsDirty +
        ",\n air is fresh: " + airFresh +
        ",\n door is open: " + doorOpen);
    return roomInfo.toString();
  }

  public boolean getShelvesClean() {
    return shelvesClean;
  }

  public void setShelvesClean(boolean shelvesClean) {
    this.shelvesClean = shelvesClean;
  }

  public boolean getBooksSorted() {
    return booksSorted;
  }

  public void setBooksSorted(boolean booksSorted) {
    this.booksSorted = booksSorted;
  }

  public boolean getCarpetClean() {
    return carpetClean;
  }

  public void setCarpetClean(boolean carpetClean) {
    this.carpetClean = carpetClean;
  }

  public boolean getTablesTidy() {
    return tablesTidy;
  }

  public void setTablesTidy(boolean tablesTidy) {
    this.tablesTidy = tablesTidy;
  }

  public boolean getWindowsDirty() {
    return windowsDirty;
  }

  public void setWindowsDirty(boolean windowsDirty) {
    this.windowsDirty = windowsDirty;
  }

  public boolean getAirFresh() {
    return airFresh;
  }

  public void setAirFresh(boolean airFresh) {
    this.airFresh = airFresh;
  }

  public boolean getDoorOpen() {
    return doorOpen;
  }

  public void setDoorOpen(boolean doorOpen) {
    this.doorOpen = doorOpen;
  }
}
