package com.twlghtzn.workshop.model;

public class DoublingResult {
  private int received;
  private int result;

  public DoublingResult(int received) {
    this.received = received;
    this.result = received * 2;
  }

  public int getReceived() {
    return received;
  }

  public int getResult() {
    return result;
  }
}
