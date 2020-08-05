package reservations;

import java.util.Random;

public class RandomDOW {

  static String randomDOW() {
    String[] dow = new String[7];
    dow[0] = "MON";
    dow[1] = "TUE";
    dow[2] = "WED";
    dow[3] = "THU";
    dow[4] = "FRI";
    dow[5] = "SAT";
    dow[6] = "SUN";
    Random rand = new Random();
    return dow[rand.nextInt(6)];
  }
}
