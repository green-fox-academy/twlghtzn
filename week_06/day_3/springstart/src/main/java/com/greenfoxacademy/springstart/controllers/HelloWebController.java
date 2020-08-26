package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWebController {


/*  @RequestMapping(value = "/web/greeting", method = RequestMethod.GET)
  public String greeting(Model model) {
    model.addAttribute("name", " World");
    return "greeting";
  } */

  AtomicLong counter = new AtomicLong();
  long counterValue = 0L;

/*  @RequestMapping(path="/web/greeting", method = RequestMethod.GET)
  public String greetingByName(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("counter", counter.incrementAndGet());
    return "greeting";
  } */
}
