package com.twlghtzn.workshop.controllers;

import com.twlghtzn.workshop.services.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketController {
  private ShipService shipService;

  public RocketController(ShipService shipService) {
    this.shipService = shipService;
  }

  @RequestMapping("/rocket")
  public ResponseEntity showShipStatus() {
    return ResponseEntity.status(HttpStatus.OK).body(shipService.getActualCargo());
  }

  @RequestMapping("/rocket/fill")
  public ResponseEntity fillShip(@RequestParam(name = "caliber", required = false) String caliber,
                                 @RequestParam(name = "amount", required = false) Integer amount) {
    if (caliber != null && amount != null) {
      shipService.addCargo(caliber, amount);
      return ResponseEntity.status(HttpStatus.OK)
          .body(shipService.getARocketOKResponse(caliber, amount));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(shipService.getARocketBadRequestResponse());
    }
  }
}
