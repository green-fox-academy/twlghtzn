package com.twlghtzn.foxclub.controllers;

import com.twlghtzn.foxclub.services.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  FoxService foxService;

  public MainController(FoxService foxService) {
    this.foxService = foxService;
    this.foxService.addFox();
  }

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String showIndex(Model model, @RequestParam(name = "name", required = false) String name) {
    if (name == null) {
      return "index";
    }
    model.addAttribute("fox", foxService.findFox(name));
    model.addAttribute("name", name);
    return "foxindex";
  }

  @RequestMapping(path="/login", method = RequestMethod.GET)
  public String showLoginPage() {
    return "login";
  }

  @PostMapping(path = "/login")
  public String logIn(Model model, @RequestParam(name = "name") String name) {
    if (name == null) {
      return "login";
    }
    foxService.addFox();
    foxService.getFoxes().get(0).setName(name);
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  @RequestMapping(path = "/nutstore", method = RequestMethod.GET)
  public String showNutStore(Model model, @RequestParam(name = "name", required = false) String name) {
    if (name == null) {
      return "login";
    }
    model.addAttribute("fox", foxService.findFox(name));
    model.addAttribute("name", name);
    return "nutstore";
  }

  @PostMapping(path = "/nutstore")
  public String changeFoodAndDrink(Model model, @RequestParam(name = "name",
      required = false) String name, @RequestParam(name = "food", required = false) String food, @RequestParam(name = "drink", required = false) String drink) {
    if (name == null) {
      return "login";
    }
    foxService.findFox(name).setFood(food);
    foxService.findFox(name).setDrink(drink);
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }
}
