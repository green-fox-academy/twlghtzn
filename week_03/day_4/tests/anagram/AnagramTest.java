package anagram;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
  Anagram anagram;

  @Before
  public void setup() {
    anagram = new Anagram();
  }

  @Test
  public void isAnagramTest() {
    String a = "blablabla";
    String b = "other_blablabla";
    assertEquals(true, anagram.areAnagrams(a, a));
    assertEquals(false, anagram.areAnagrams(a, b));
  }

}