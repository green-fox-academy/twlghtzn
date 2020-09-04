package com.twlghtzn.foxclub.controllers;

import com.twlghtzn.foxclub.models.Fox;
import com.twlghtzn.foxclub.services.FoxService;
import com.twlghtzn.foxclub.services.ThingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThingsController {
  FoxService foxService;
  ThingsService thingsService;

  public ThingsController(FoxService foxService,
                          ThingsService thingsService) {
    this.foxService = foxService;
    this.thingsService = thingsService;
  }

  @RequestMapping(path = "/nutstore", method = RequestMethod.GET)
  public String showNutStore(Model model, @RequestParam(name = "name", required = false) String name) {
    if (name == null) {
      return "login";
    }
    model.addAttribute("fox", findFox(name));
    model.addAttribute("name", name);
    model.addAttribute("foods", thingsService.getFoods());
    model.addAttribute("drinks", thingsService.getDrinks());
    return "nutstore";
  }

  @PostMapping(path = "/nutstore")
  public String changeFoodAndDrink(Model model, @RequestParam(name = "name",
      required = false) String name, @RequestParam(name = "food", required = false) String food, @RequestParam(name = "drink", required = false) String drink) {
    if (name == null) {
      return "login";
    }
    findFox(name).setFood(food);
    findFox(name).setDrink(drink);
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  @RequestMapping(path = "/trickcenter")
  public String showTrickCenter(Model model, @RequestParam(name = "name", required = false) String name) {
    if (name == null) {
      return "login";
    }
    model.addAttribute("fox", findFox(name));
    model.addAttribute("name", name);
    model.addAttribute("newTricks", thingsService.getNewTricks(findFox(name)));
    return "trickcenter";
  }

  @PostMapping(path = "/trickcenter")
  public String learnNewTrick(Model model, @RequestParam(name = "name",
      required = false) String name, @RequestParam(name = "trick", required = false) String trickName) {
    if (name == null) {
      return "login";
    }
    findFox(name).addToLearnedTricks(thingsService.findTrick(trickName));
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  public Fox findFox(String name) {
    return foxService.findFox(name);
  }
}
