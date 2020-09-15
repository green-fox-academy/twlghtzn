package com.twlghtzn.workshop.model;

import lombok.Getter;

@Getter
public class AppendAResult {
  private String appended;

  public AppendAResult(String appendable) {
    appended = appendable + "a";
  }
}
