package com.twlghtzn.reddit.controllers;

import com.twlghtzn.reddit.models.User;
import com.twlghtzn.reddit.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {
  private final UserService userService;


  @RequestMapping(path = "/login", method = RequestMethod.GET)
  public String showLoginPage(Model model,
                              @RequestParam(name = "info", required = false) String info) {
    if (info != null && info.equals("newUser")) {
      model.addAttribute("info", "newUser");
    } else if (info != null && info.equals("signUpOK")) {
      model.addAttribute("info", "signUpOK");
    } else if (info != null && info.equals("nameTaken")) {
      model.addAttribute("info", "nameTaken");
    }
    return "login";
  }

  @PostMapping(path = "/login")
  public String authenticateUser(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "password") String password) {
    if (userService.isUserRegistered(name, password)) {
      User user = userService.findUserByNameAndPassword(name, password);
      return "redirect:/?id=" + user.getId();
    } else {
      return "redirect:/login?info=newUser";
    }
  }

  @PostMapping(path = "/signup")
  public String registerNewUser(@RequestParam(name = "name") String name,
                                @RequestParam(name = "password") String password) {
    userService.addUser(name, password);
    if (userService.findUserByNameAndPassword(name, password) == null) {
      return "redirect:/login?info=nameTaken";
    } else {
      return "redirect:/login?info=signUpOK";
    }
  }
}
