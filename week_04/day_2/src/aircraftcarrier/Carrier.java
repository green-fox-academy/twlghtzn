package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  String name;
  List<Aircraft> aircrafts;
  int ammoStore;
  int healthPoints;

  public Carrier(String name, int ammoStore, int healthPoints) {
    this.name = name;
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
      for (Aircraft aircraft : aircrafts) {
        if (aircraft.isPriority) {
          if ((aircraft.maxAmmo - aircraft.ammunition) < this.ammoStore) {
            aircraft.refill(this.ammoStore);
            this.ammoStore = aircraft.refill(this.ammoStore);
          }
        }
      }
    } else if (this.ammoStore > 0){
      for(Aircraft aircraft: aircrafts) {
        if((aircraft.maxAmmo - aircraft.ammunition) < this.ammoStore){
          this.ammoStore = aircraft.refill(this.ammoStore);
        } else {
          break;
        }
      }
    }
    System.out.println(this.name + " refills aircrafts.");
    System.out.println("-------------------------------------------------------------------");
  }

  public void fight(Carrier anotherCarrier) {
    if (this.healthPoints <= 0) {
      System.out.println(this.name + " is dead, can't fight.");
      System.out.println("-------------------------------------------------------------------");
    } else {
      System.out.println(this.name + " fights " + anotherCarrier.name + ".");
      System.out.println("-------------------------------------------------------------------");
        for (Aircraft aircraft : aircrafts) {
          if (aircraft.baseDamage * aircraft.ammunition <= anotherCarrier.healthPoints) {
            anotherCarrier.healthPoints -= aircraft.fight();
          } else {
            anotherCarrier.healthPoints -= aircraft.fight();
            break;
          }
        }
    }
  }


  public int totalDamage() {
    int totalDamage = 0;
    for (Aircraft aircraft: aircrafts) {
      totalDamage += aircraft.ammunition * aircraft.baseDamage;
    }
    return totalDamage;
  }

  public void getStatus() {
    System.out.println(this.name);
    if (this.healthPoints <= 0) {
      System.out.println("It's dead Jim :(");
    } else {
      System.out.println("HP: " + this.healthPoints + ", Aircraft count: " + this.aircrafts.size() +
          ", Ammo Storage: " + this.ammoStore + ", Total damage: " + this.totalDamage());
      System.out.println("Aircrafts:");
      for (Aircraft aircraft : aircrafts) {
        System.out.println(aircraft.getStatus());
      }
    }
    System.out.println("-------------------------------------------------------------------");
  }
}
