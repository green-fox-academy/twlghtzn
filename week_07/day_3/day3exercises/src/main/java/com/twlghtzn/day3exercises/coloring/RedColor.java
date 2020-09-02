package com.twlghtzn.day3exercises.coloring;

import org.springframework.stereotype.Service;

@Service
public class RedColor  implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is red... ");
  }
}
