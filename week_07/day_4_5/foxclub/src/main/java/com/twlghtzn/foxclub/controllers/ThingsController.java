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
public class ThingsController {
  FoxService foxService;
  ThingsService thingsService;

  public ThingsController(FoxService foxService,
                          ThingsService thingsService) {
    this.foxService = foxService;
    this.thingsService = thingsService;
  }

  @RequestMapping(path = "/nutstore", method = RequestMethod.GET)
  public String showNutStore(Model model,
                             @RequestParam(name = "name", required = false) String name) {
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
      required = false) String name, @RequestParam(name = "food", required = false) String food,
                                   @RequestParam(name = "drink", required = false) String drink) {
    if (name == null) {
      return "login";
    }
    String prevFood = findFox(name).getFood();
    String prevDrink = findFox(name).getDrink();
    findFox(name).setFood(food);
    findFox(name).addAction(getTimeStamp() + " : Food has been changed from: " + prevFood + " to " +
        findFox(name).getFood());
    findFox(name).setDrink(drink);
    findFox(name).addAction(
        getTimeStamp() + " : Drink has been changed from: " + prevDrink + " to " +
            findFox(name).getDrink());
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  @RequestMapping(path = "/trickcenter")
  public String showTrickCenter(Model model,
                                @RequestParam(name = "name", required = false) String name) {
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
      required = false) String name,
                              @RequestParam(name = "trick", required = false) String trickName) {
    if (name == null) {
      return "login";
    }
    findFox(name).addToLearnedTricks(thingsService.findTrick(trickName));
    findFox(name).addAction(getTimeStamp() + " : Learned this trick: " + trickName);
    model.addAttribute("name", name);
    return "redirect:/?name=" + name;
  }

  @RequestMapping(path = "/actionhistory")
  public String showActionHistory(Model model,
                                  @RequestParam(name = "name", required = false) String name) {
    model.addAttribute("name", name);
    model.addAttribute("fox", findFox(name));
    return "actionhistory";
  }

  public Fox findFox(String name) {
    return foxService.findFox(name);
  }

  public String getTimeStamp() {
    String ldt = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    return ldt.replace('T', ' ');
  }
}
