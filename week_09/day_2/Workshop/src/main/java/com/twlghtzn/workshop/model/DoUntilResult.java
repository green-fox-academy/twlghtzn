package com.twlghtzn.workshop.model;

import java.util.stream.LongStream;
import lombok.Getter;

@Getter
public class DoUntilResult {
  private final int result;

  public DoUntilResult(String action, int until) {
    result = calculateResult(action, until);
  }

  public int calculateResult(String action, int until) {
    int sum = 0;
    if (action.equals("sum")) {
      for (int i = 1; i < until + 1; i++) {
        sum = sum + i;
      }
      return sum;
    } else {
      return (int) LongStream.rangeClosed(1, until)
          .reduce(1, (long x, long y) -> x * y);
    }
  }
}
