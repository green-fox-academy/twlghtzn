package com.twlghtzn.workshop.models;

import org.springframework.beans.factory.annotation.Autowired;

public class GrootOKResponse {
  private String received;
  private String translated;

  @Autowired
  public GrootOKResponse(String received) {
    this.received = received;
    translated = "I am Groot!";
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}
