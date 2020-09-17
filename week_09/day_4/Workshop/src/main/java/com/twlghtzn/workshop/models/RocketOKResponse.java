package com.twlghtzn.workshop.models;

public class RocketOKResponse {
  private String received;
  private int amount;
  private String shipstatus;
  private boolean ready;

  public RocketOKResponse(String received, int amount, String shipstatus, boolean ready) {
    this.received = received;
    this.amount = amount;
    this.shipstatus = shipstatus;
    this.ready = ready;
  }

  public String getReceived() {
    return received;
  }

  public int getAmount() {
    return amount;
  }

  public String getShipstatus() {
    return shipstatus;
  }

  public boolean isReady() {
    return ready;
  }
}
