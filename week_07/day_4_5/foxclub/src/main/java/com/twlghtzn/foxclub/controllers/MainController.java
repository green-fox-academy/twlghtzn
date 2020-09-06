package com.twlghtzn.foxclub.controllers;

import com.twlghtzn.foxclub.models.Fox;
import com.twlghtzn.foxclub.services.FoxService;
import com.twlghtzn.foxclub.services.ThingsService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  FoxService foxService;
  ThingsService thingsService;

  public MainController(FoxService foxService, ThingsService thingsService) {
    this.thingsService = thingsService;
    this.foxService = foxService;
    foxService.getFoxes().remove(findLastAddedFox());
  }

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String showIndex(Model model,
                          @RequestParam(name = "name", required = false) String name) {
    if (name == null) {
      return "index";
    }
    model.addAttribute("fox", findFox(name));
    model.addAttribute("name", name);
    return "foxindex";
  }

  @RequestMapping(path = "/login", method = RequestMethod.GET)
  public String showLoginPage(Model model,
                              @RequestParam(name = "warning", required = false) String warning) {
    if (warning != null && warning.equals("foxnotinlist")) {
      model.addAttribute("warning", true);
      return "login";
    }
    return "login";
  }

  @PostMapping(path = "/login")
  public String logIn(Model model, @RequestParam(name = "name") String name) {
    if (name == null || findFox(name) == null) {
      model.addAttribute("warning", "foxnotinlist");
      return "redirect:/login?warning=foxnotinlist";
    }
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  @PostMapping(path = "/addfox")
  public String addFox(Model model, @RequestParam(name = "newFox") String newFox) {
    if (newFox != null) {
      foxService.addFox();
      findLastAddedFox().setName(newFox);
      findLastAddedFox().addAction(getTimeStamp() + " : New fox " +
          findLastAddedFox().getName() + " was created");
      thingsService.setupNewFox(findLastAddedFox());
      model.addAttribute("fox", findLastAddedFox());
      model.addAttribute("name", newFox);
      return "redirect:/?name=" + newFox;
    }
    model.addAttribute("warning", "foxnotinlist");
    return "redirect:/login?warning=foxnotinlist";
  }

  public Fox findFox(String name) {
    return foxService.findFox(name);
  }

  public Fox findLastAddedFox() {
    return foxService.getFoxes().get(0);
  }

  public String getTimeStamp() {
    String ldt = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    return ldt.replace('T', ' ');
  }
}
