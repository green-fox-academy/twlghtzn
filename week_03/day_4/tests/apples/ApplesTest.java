package apples;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ApplesTest {
  Apples apples;

  @Test
  public void testGetApple() {
    Apples a = new Apples();
    assertEquals("apple", a.getApple());
  }

}