package com.twlghtzn.workshop.controllers;

import com.twlghtzn.workshop.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {
  private WorkshopService workshopService;

  @Autowired
  public GuardianController(WorkshopService workshopService) {
    this.workshopService = workshopService;
  }

  @RequestMapping("/groot")
  public ResponseEntity translateMessageIntoGroot(
      @RequestParam(name = "message", required = false) String message) {
    if (message != null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(workshopService.getAGrootOKResponse(message));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(workshopService.getAGrootBadRequestResponse());
    }
  }

  @RequestMapping("/yondu")
  public ResponseEntity getArrowSpeed(
      @RequestParam(name = "distance", required = false) Double distance,
      @RequestParam(name = "time", required = false) Double time) {
    if (distance != null && time != null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(workshopService.getAYonduOKResponse(distance, time));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(workshopService.getAYonduBadRequestResponse());
    }
  }
}
