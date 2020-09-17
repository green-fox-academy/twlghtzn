package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.models.RocketBadRequestResponse;
import com.twlghtzn.workshop.models.RocketOKResponse;
import com.twlghtzn.workshop.models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
  private Ship ship;

  @Autowired
  public ShipService() {
    ship = new Ship();
  }

  public Ship getActualCargo() {
    checkShip();
    return ship;
  }

  public void clearShip() {
    ship.setCaliber25(0);
    ship.setCaliber30(0);
    ship.setCaliber50(0);
    ship.setShipstatus("empty");
    ship.setReady(false);
  }

  public void addCargo(String caliber, int amount) {
    if (caliber.equals(".25")) {
      ship.setCaliber25(ship.getCaliber25() + amount);
    } else if (caliber.equals(".30")) {
      ship.setCaliber30(ship.getCaliber30() + amount);
    } else if (caliber.equals(".50")) {
      ship.setCaliber50(ship.getCaliber50() + amount);
    }
    checkShip();
  }

  public void checkShip() {
    ship.setShipstatus(calculateShipStatus());
    if (ship.getShipstatus().equals("full")) {
      ship.setReady(true);
    } else {
      ship.setReady(false);
    }
  }

  public String calculateShipStatus() {
    float cargoSum = ship.getCaliber25() + ship.getCaliber30() + ship.getCaliber50();
    if (cargoSum == 0) {
      return "empty";
    } else if (cargoSum < 12500) {
      int percent = (int) Math.ceil((cargoSum / 12500) * 100);
      return percent + "%";
    } else if (cargoSum == 12500) {
      return "full";
    } else {
      return "overloaded";
    }
  }

  public RocketOKResponse getARocketOKResponse(String caliber, int amount) {
    checkShip();
    return new RocketOKResponse(caliber, amount, ship.getShipstatus(), ship.isReady());
  }

  public RocketBadRequestResponse getARocketBadRequestResponse() {
    return new RocketBadRequestResponse();
  }
}
