package main.java.zoo;

import static org.junit.Assert.*;


import org.junit.Test;

public class ReptileTest {

  @Test
  public void breed() {
    Reptile reptile = new Reptile("Croc");
    reptile.breed();
    assertEquals(reptile.breed(), "laying eggs.");
  }
}