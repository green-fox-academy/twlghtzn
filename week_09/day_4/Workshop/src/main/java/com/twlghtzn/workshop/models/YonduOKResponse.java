package com.twlghtzn.workshop.models;

public class YonduOKResponse {
  private double distance;
  private double time;
  private double speed;

  public YonduOKResponse(double distance, double time) {
    this.distance = Math.round(distance * 10) / 10.0;
    this.time = Math.round(time * 10) / 10.0;
    if (time != 0) {
      speed = Math.round((distance / time) * 10 / 10.0);
    } else {
      speed = distance;
    }
  }

  public double getDistance() {
    return distance;
  }

  public double getTime() {
    return time;
  }

  public double getSpeed() {
    return speed;
  }
}
