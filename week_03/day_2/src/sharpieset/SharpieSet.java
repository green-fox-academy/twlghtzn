package sharpieset;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {

  public static List<Sharpie> initializeSharpieSet() {
    List<Sharpie> sharpies = new ArrayList<>();
    sharpies.add(new Sharpie("black", 4));
    sharpies.add(new Sharpie("red", 4));
    sharpies.add(new Sharpie("pink", 4));
    sharpies.add(new Sharpie("green", 4));

    return sharpies;
  }

  public static void inUse(Sharpie a) {
    a.inkAmount -= 10;
  }

  public static void main(String[] args) {
    List<Sharpie> sharpieSet = initializeSharpieSet();

    inUse(sharpieSet.get(0));
    inUse(sharpieSet.get(0));
    inUse(sharpieSet.get(0));
    inUse(sharpieSet.get(2));
    inUse(sharpieSet.get(2));
    inUse(sharpieSet.get(2));

    System.out.println(countUsable(sharpieSet));
    removeTrash(sharpieSet);

  }

  public static int countUsable(List<Sharpie> sharpies) {
    int countUsable = 0;
    for (Sharpie sharpie : sharpies) {
      if (sharpie.inkAmount != 0) {
        countUsable++;
      }
    }
    return countUsable;
  }

  public static void removeTrash(List<Sharpie> sharpies) {
    for (int i = 0; i < sharpies.size(); i++) {
      if (sharpies.get(i).inkAmount == 0) {
        sharpies.remove(sharpies.get(i));
      }
    }
  }
}
