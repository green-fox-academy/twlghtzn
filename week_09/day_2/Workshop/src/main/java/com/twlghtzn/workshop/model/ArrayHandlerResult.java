package com.twlghtzn.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayHandlerResult {
  private final List<Integer> result;

  public ArrayHandlerResult(ArrayHandlerRequest arrayHandlerRequest) {
    result = new ArrayList<>();
    setResult(arrayHandlerRequest);
  }

  public List<Integer> getResult() {
    return result;
  }

  public void setResult(ArrayHandlerRequest arrayHandlerRequest) {
    List<Integer> numbers = arrayHandlerRequest.getNumbers();
    String what = arrayHandlerRequest.getWhat();
    if (what.equals("sum")) {
      int sum1 = 0;
      for (Integer number : numbers) {
        sum1 = sum1 + number;
      }
      result.add(sum1);
    } else if (what.equals("multiply")) {
      int sum2 = 1;
      for (Integer number : numbers) {
        sum2 = sum2 * number;
      }
      result.add(sum2);
    } else if (what.equals("double")) {
      for (Integer number : numbers) {
        result.add(number * 2);
      }
    }
  }

}
