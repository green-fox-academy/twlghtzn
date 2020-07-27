package fleetofthings;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main` method
    // - Download those, use those
    // - In the main method create a fleet
    // - Achieve this output:
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    Thing a = new Thing("Get milk");
    Thing b = new Thing("Remove the obstacles");
    Thing c = new Thing("Stand up");
    c.complete();
    Thing d = new Thing("Eat lunch");
    d.complete();

    Fleet ize = new Fleet();
    ize.add(a);
    ize.add(b);
    ize.add(c);
    ize.add(d);

    System.out.println(ize);
  }

}
