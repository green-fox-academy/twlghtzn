package com.twlghtzn.workshop.models;

public class YonduBadRequestResponse {
  private String error;

  public YonduBadRequestResponse() {
    error = "Something's missing, pal.";
  }

  public String getError() {
    return error;
  }
}
