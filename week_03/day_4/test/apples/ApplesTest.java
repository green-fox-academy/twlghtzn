package apples;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
class ApplesTest {

  @Test
  public void testGetApple() {
    Apples apples = new Apples();
    assertEquals("apple", apples.getApple());
  }

}