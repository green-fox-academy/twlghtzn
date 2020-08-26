package sum;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SumTest {
  Sum sum;

  @Before
  public void setup() {
    sum = new Sum();
  }


  @Test
  public void isSumCorrect() {
    List<Integer> testList = new ArrayList<>();
    testList.add(3);
    testList.add(4);
    testList.add(8);
    testList.add(11);
    testList.add(32);
    assertEquals(58, sum.sum(testList));
  }

  @Test
  public void isSumCorrectEmptyArray() {
    List<Integer> testList = new ArrayList<>();
    assertEquals(0, sum.sum(testList));
  }

  @Test
  public void isSumCorrectOneInt() {
    List<Integer> testList = new ArrayList<>();
    testList.add(3);
    assertEquals(3, sum.sum(testList));
  }

}