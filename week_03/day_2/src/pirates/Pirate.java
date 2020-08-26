package pirates;

public class Pirate {
  String name;
  boolean isCaptain;
  int rumsCount = 0;
  boolean passedOut;
  boolean isDead;

  public Pirate(String name, boolean isCaptain) {
    this.name = name;
    this.isCaptain = isCaptain;
  }

  public void drinkSomeRum(Pirate a) {
    if (a.isDead) {
      System.out.println(a.name + " is dead, can't drink.");
    } else {
      a.rumsCount++;
    }
  }

  public static void howsItGoingMate(Pirate a) {
    if (a.rumsCount < 5) {
      System.out.println(a.name + ": Pour me anudder!");
    } else {
      System.out.println(a.name + ": Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      a.passedOut = true;
    }
  }

  public static void brawl(Pirate a, Pirate b) {
    System.out.println(a.name + " has a brawl with " + b.name);
    if (a.isDead || a.passedOut || b.isDead || b.passedOut) {
      System.out.println("No brawl.");
    } else {
      int chance = (int) (Math.random() * 10);
      if (0 < chance && chance <= 3) {
        a.isDead = true;
        System.out.println(a.name + " is dead.");
      } else if (3 < chance && chance <= 6) {
        b.isDead = true;
        System.out.println(b.name + " is dead.");
      } else {
        a.passedOut = true;
        b.passedOut = true;
        System.out.println(a.name + " and " + b.name + " passed out");
      }
    }
  }


}
