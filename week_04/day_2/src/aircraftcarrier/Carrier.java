package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  List<Aircraft> aircrafts;
  int ammoStore;
  int healthPoints;

  public Carrier(int ammoStore, int healthPoints) {
    this.ammoStore = ammoStore;
    this.healthPoints = healthPoints;
    this.aircrafts = new ArrayList<>();
  }

  public void addAircraft(Aircraft newAircraft) {
    this.aircrafts.add(newAircraft);
  }

  public void fillAircrafts() {
    int neededAmmo = 0;
    for (Aircraft aircraft: aircrafts) {
      neededAmmo += (aircraft.maxAmmo - aircraft.ammunition);
    }
    if (neededAmmo > this.ammoStore) {
      for (Aircraft aircraft: aircrafts) {
        if (aircraft.isPriority) {
          if ((aircraft.maxAmmo - aircraft.ammunition) < this.ammoStore) {
            aircraft.refill(this.ammoStore);
          } else {
            break;
          }
        }
      }
      if (this.ammoStore > 0) {
        for (Aircraft aircraft: aircrafts) {
          if ((aircraft.maxAmmo - aircraft.ammunition) < this.ammoStore) {
            aircraft.refill(this.ammoStore);
          } else {
            break;
          }
        }
      }
    }
  }

  public void fight(Carrier anotherCarrier) {
    int totalDamage = 0;
    for (Aircraft aircraft: aircrafts) {
      totalDamage += aircraft.fight();
    }
    anotherCarrier.healthPoints -= totalDamage;
  }

  public int totalDamage() {
    int totalDamage = 0;
    for (Aircraft aircraft: aircrafts) {
      totalDamage += aircraft.fight();
    }
    return totalDamage;
  }

  public void getStatus() {
    if (this.healthPoints == 0) {
      System.out.println("It's dead Jim :(");
    } else {
      System.out.println("HP: " + this.healthPoints + ", Aircraft count: " + this.aircrafts.size() +
          ", Ammo Storage: " + this.ammoStore + ", Total damage: " + this.totalDamage());
      System.out.println("Aircrafts:");
      for (Aircraft aircraft : aircrafts) {
        System.out.println(aircraft.getStatus());
      }
    }
  }
}
