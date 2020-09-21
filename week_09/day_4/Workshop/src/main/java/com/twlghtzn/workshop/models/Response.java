package com.twlghtzn.workshop.models;

import lombok.Getter;

@Getter
public class Response {
  private String message;

  public Response(String message) {
    this.message = message;
  }
}
