package pirates;

import static pirates.Pirate.brawl;
import static pirates.Pirate.howsItGoingMate;


import java.util.ArrayList;
import java.util.List;

public class Ship {
  String name;
  List<Pirate> crew;

  public Ship(String name) {
    this.name = name;
  }





  public static List<Pirate> fillShip(Ship a) {
    List<Pirate> crew = new ArrayList<>();
    crew.add(new Pirate("Béla", false));
    crew.add(new Pirate("Elek", false));
    crew.add(new Pirate("Gyuri", false));
    crew.add(new Pirate("Jack", true));
    a.crew = crew;
    return crew;
  }

  public static void stateOfShip(Ship a) {
    for (int i = 0; i < a.crew.size(); i++) {
      if (!a.crew.get(i).isCaptain && a.crew.get(i).isDead) {
        System.out.println(
            a.name + "'s " + a.crew.get(i).name + " pirate Rums: " + a.crew.get(i).rumsCount +
                " -- is dead");
      } else if (!a.crew.get(i).isCaptain && a.crew.get(i).passedOut) {
        System.out.println(
          a.name + "'s " + a.crew.get(i).name + " pirate Rums: " + a.crew.get(i).rumsCount +
              " -- passed out");
      } else if (!a.crew.get(i).isCaptain) {
      System.out.println(
          a.name + "'s " + a.crew.get(i).name + " pirate Rums: " + a.crew.get(i).rumsCount);
      } else if (a.crew.get(i).isCaptain && a.crew.get(i).isDead) {
        System.out.println(
            a.name + "'s captain: " + a.crew.get(i).name + " Rums: " + a.crew.get(i).rumsCount +
                " -- is dead");
      } else if (a.crew.get(i).isCaptain && a.crew.get(i).passedOut) {
        System.out.println(
            a.name + "'s captain: " + a.crew.get(i).name + " Rums: " + a.crew.get(i).rumsCount +
                " -- passed out");
      } else if (a.crew.get(i).isCaptain) {
        System.out.println(
            a.name + "'s captain: " + a.crew.get(i).name + " Rums: " + a.crew.get(i).rumsCount);
      }
    }
    int aliveCount = 0;
    for (int i = 0; i < a.crew.size(); i++) {
      if (!a.crew.get(i).isDead) {
        aliveCount++;
      }
    }
    System.out.println(a.name + " has " + aliveCount + " pirates alive");
  }

  public static void main(String[] args) {
    Ship blackPearl = new Ship("Black Pearl");
    List<Pirate> blackPearlCrew = fillShip(blackPearl);

    blackPearlCrew.get(0).drinkSomeRum(blackPearlCrew.get(0));
    blackPearlCrew.get(3).drinkSomeRum(blackPearlCrew.get(3));
    blackPearlCrew.get(3).drinkSomeRum(blackPearlCrew.get(3));
    brawl(blackPearlCrew.get(0), blackPearlCrew.get(1));
    howsItGoingMate(blackPearlCrew.get(2));
    howsItGoingMate(blackPearlCrew.get(3));
    blackPearlCrew.get(3).drinkSomeRum(blackPearlCrew.get(3));
    blackPearlCrew.get(3).drinkSomeRum(blackPearlCrew.get(3));
    blackPearlCrew.get(3).drinkSomeRum(blackPearlCrew.get(3));
    brawl(blackPearlCrew.get(3), blackPearlCrew.get(0));
    howsItGoingMate(blackPearlCrew.get(3));

    stateOfShip(blackPearl);

  }
}

