package com.twlghtzn.workshop.model;

import lombok.Getter;

@Getter
public class GreeterResult {
  private final String welcome_message;

  public GreeterResult(String name, String title) {
    welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
  }
}
