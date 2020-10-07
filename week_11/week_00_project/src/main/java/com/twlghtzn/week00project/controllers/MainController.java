package com.twlghtzn.week00project.controllers;

import com.twlghtzn.week00project.models.dtos.TokenResponse;
import com.twlghtzn.week00project.services.TMDBService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  private TMDBService tmdbService;

  @Autowired
  public MainController(TMDBService tmdbService) {
    this.tmdbService = tmdbService;
  }

  @GetMapping("/authentication/token/new")
  public TokenResponse requestNewToken() throws IOException {
    return tmdbService.getNewToken();
  }
}
