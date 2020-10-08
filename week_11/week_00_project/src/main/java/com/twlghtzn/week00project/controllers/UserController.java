package com.twlghtzn.week00project.controllers;

import com.twlghtzn.week00project.services.JWTService;
import com.twlghtzn.week00project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private UserService userService;
  private JWTService jwtService;

  @Autowired
  public UserController(UserService userService, JWTService jwtService) {
    this.userService = userService;
    this.jwtService = jwtService;
  }

  @GetMapping("/register")
  public ResponseEntity<?> registerUser(@RequestParam String userName,
                                        @RequestParam String password) {
    userService.addUser(userName, password);
    if (userService.areUserCredentialsValid(userName, password)) {
      return ResponseEntity.status(HttpStatus.OK).body(jwtService.createJWT(userName));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wut");
    }
  }

  @GetMapping("/login")
  public ResponseEntity<?> login(@RequestHeader("authorization") String jwt) {
    String realJwt = jwt.substring(7);
    String userName = jwtService.readUserNameFromJWT(realJwt);
    return ResponseEntity.status(HttpStatus.OK).body("Hello, " + userName);
  }
}
