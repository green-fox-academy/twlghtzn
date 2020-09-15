package com.twlghtzn.workshop.controllers;

import com.twlghtzn.workshop.model.AppendAResult;
import com.twlghtzn.workshop.model.ArrayHandlerRequest;
import com.twlghtzn.workshop.model.ArrayHandlerResult;
import com.twlghtzn.workshop.model.DoUntilResult;
import com.twlghtzn.workshop.model.DoublingResult;
import com.twlghtzn.workshop.model.GreeterResult;
import com.twlghtzn.workshop.model.Until;
import com.twlghtzn.workshop.services.ErrorMessageService;
import com.twlghtzn.workshop.services.LogService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {
  private final ErrorMessageService errorMessageService;
  private final LogService logService;

  @RequestMapping("/doubling")
  public ResponseEntity doubleInput(
      @RequestParam(name = "input", required = false) String input) {
    logService.addLog(LocalDateTime.now(), "/doubling", "input=" + input);
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(errorMessageService.getErrors().get(0));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new DoublingResult(Integer.parseInt(input)));
    }
  }

  @RequestMapping("/greeter")
  public ResponseEntity greet(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String title) {
    logService.addLog(LocalDateTime.now(), "/greeter",
        logService.appendAToString(name, title));
    if (name != null && title != null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new GreeterResult(name, title));
    } else if (name != null && title == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(errorMessageService.getErrors().get(2));
    } else if (name == null && title != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(errorMessageService.getErrors().get(3));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(errorMessageService.getErrors().get(1));
    }
  }

  @RequestMapping("/appenda/{appendable}")
  public ResponseEntity appendA(
      @PathVariable(required = false) String appendable) {
    logService.addLog(LocalDateTime.now(),
        "/appenda", "appendable=" + appendable);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new AppendAResult(appendable));
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity doUntil(@PathVariable String action,
                                @RequestBody Until until) {
    logService.addLog(LocalDateTime.now(), "/dountil",
        logService.untilToString(action, until));
    if (until == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(errorMessageService.getErrors().get(4));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new DoUntilResult(action, until.getUntil()));
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity handleArrays(
      @RequestBody ArrayHandlerRequest arrayHandlerRequest) {
    logService.addLog(LocalDateTime.now(), "/arrays)",
        logService.requestToString(arrayHandlerRequest));
    if (arrayHandlerRequest.getWhat() != null
        && arrayHandlerRequest.getNumbers() != null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ArrayHandlerResult(arrayHandlerRequest));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(errorMessageService.getErrors().get(5));
    }
  }

  @RequestMapping("/log")
  public ResponseEntity showLogsAndCount() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(logService.getLogResponse());
  }
}
