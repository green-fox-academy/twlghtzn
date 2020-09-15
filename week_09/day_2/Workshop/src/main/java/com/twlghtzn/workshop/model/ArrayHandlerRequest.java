package com.twlghtzn.workshop.model;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArrayHandlerRequest {
  private final String what;
  private final List<Integer> numbers;

  public String getWhat() {
    return what;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
