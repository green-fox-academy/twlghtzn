package main.java.zoo;

import junit.framework.TestCase;
import org.junit.Test;

public class BirdTest extends TestCase {

  @Test
  public void testGetName() {
    Bird bird = new Bird("Birdy");
    bird.getName();
    assertEquals(bird.getName(), "Birdy");
  }
}