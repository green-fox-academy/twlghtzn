package sum;

import java.util.List;

public class Sum {
  List<Integer> integers;

  public Integer sum(List<Integer> a) {
    Integer sum = 0;
    if (a.size() == 0) {
      return sum;
    } else {
      for (Integer integer : a) {
        sum += integer;
      }
    }
    return sum;
  }

}
