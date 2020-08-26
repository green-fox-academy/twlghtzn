package countletters;

import static countletters.CountLetters.countLetters;
import static org.junit.Assert.assertTrue;


import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class CountLettersTest {
  CountLetters countLetters;

  @Before
  public void setup() {
    countLetters = new CountLetters();
  }

  @Test
  public void isCountLettersCorrect() {
    String a = "AAaaBBbbCCcc12345";
    HashMap test = new HashMap();
    test.put('A', 2);
    test.put('a', 2);
    test.put('1', 1);
    test.put('B', 2);
    test.put('b', 2);
    test.put('2', 1);
    test.put('C', 2);
    test.put('c', 2);
    test.put('3', 1);
    test.put('4', 1);
    test.put('5', 1);
    assertTrue(test.equals(countLetters(a)));

  }


}
