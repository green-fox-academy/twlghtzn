package com.twlghtzn.week00project.controllers;

import com.twlghtzn.week00project.models.dtos.TokenResponse;
import com.twlghtzn.week00project.services.JWTService;
import com.twlghtzn.week00project.services.TMDBService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  private TMDBService tmdbService;
  private JWTService jwtService;

  @Autowired
  public MainController(TMDBService tmdbService, JWTService jwtService) {
    this.tmdbService = tmdbService;
    this.jwtService = jwtService;
  }

  @GetMapping("/authentication/token/new")
  public TokenResponse requestNewToken() throws IOException {
    return tmdbService.getNewToken();
  }

  @GetMapping("/findEMIs")
  public ResponseEntity<?> getExternalMovieIds(@RequestParam(name = "movie_id") String movie_id,
                                               @RequestHeader("authorization") String jwt)
      throws IOException {
    if (jwtService.isBearerTokenValid(jwt)) {
      tmdbService.setMovie_id(movie_id);
      return ResponseEntity.status(HttpStatus.OK).body(tmdbService.getEMIs());
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }
}
