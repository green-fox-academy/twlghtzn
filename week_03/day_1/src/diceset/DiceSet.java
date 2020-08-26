package diceset;

import java.util.ArrayList;
import java.util.List;

public class DiceSet {
  ArrayList<Integer> dices = new ArrayList<>();

  public List<Integer> roll() {
    for (int i = 0; i < 6; i++) {
      dices.add((int) (Math.random() * 6) + 1);
    }
    return dices;
  }

  public List<Integer> getCurrent() {
    return dices;
  }

  public int getCurrent(int i) {
    return dices.get(i);
  }

  public void reroll() {
    for (int i = 0; i < dices.size(); i++) {
      while (dices.get(i) != 6) {
        dices.set(i, (int) (Math.random() * 6) + 1);
        System.out.println(dices);
      }
    }
  }

/*  public void reroll(int k) {
    dices.set(k, (int) (Math.random() * 6) + 1);
  } */


  public static void main(String[] args) {
    // You have a `DiceSet` class which has a list for 6 dice
    // You can roll all of them with roll()
    // Check the current rolled numbers with getCurrent()
    // You can reroll with reroll()
    // Your task is to roll the dice until all of the dice are 6

    DiceSet diceSet = new DiceSet();
    System.out.println(diceSet.getCurrent());
    System.out.println(diceSet.roll());
    System.out.println(diceSet.getCurrent());
    diceSet.reroll();
  }
}