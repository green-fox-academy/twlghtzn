package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

/*  @RequestMapping(path="/greeting", method = RequestMethod.GET)
  public Greeting greeting() {
    return new Greeting(1, "Hello World!");
  } */

  AtomicLong atomicLong = new AtomicLong();

/*  @GetMapping("/greeting")
  public Greeting greetingByName(@RequestParam String name) {
    return new Greeting((long) atomicLong.incrementAndGet(), "Hello, " + name + "!");
  } */
}
