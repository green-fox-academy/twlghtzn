package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FizzBuzzWoofController {
  String fontSize1 = "24px";
  String fontSize2 = "48px";
  String fontSize3 = "72px";
  String counter1 = "Fizz";
  String counter2 = "Buzz";
  String counter3 = "Woof";

  AtomicLong atomicLong = new AtomicLong();

  @GetMapping("web/fbw")
  public String fizzBuzzWoof(Model model) {
    long counter = atomicLong.incrementAndGet();
    StringBuilder counterToDisplay = new StringBuilder();
    String fontToDisplay = "";
    if (counter % 3 == 0) {
      counterToDisplay.append(counter1);
    }
    if (counter % 5 == 0) {
      counterToDisplay.append(counter2);
    }
    if (counter % 7 == 0) {
      counterToDisplay.append(counter3);
    }
    if (counterToDisplay.length() == 4) {
      fontToDisplay = fontSize1;
    } else if (counterToDisplay.length() == 8) {
      fontToDisplay = fontSize2;
    } else if (counterToDisplay.length() == 12) {
      fontToDisplay = fontSize3;
    } else {
      fontToDisplay = "18px";
      counterToDisplay.append(counter);
    }
    model.addAttribute("counter", counterToDisplay);
    model.addAttribute("font", fontToDisplay);
    return "fbw";
  }
}
