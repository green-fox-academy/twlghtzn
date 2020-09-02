package com.twlghtzn.day3exercises;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UUController {
  UtilityService utilityService;

  @RequestMapping(path = "/useful", method = RequestMethod.GET)
  public String showMain() {
    return "index";
  }

  @RequestMapping(path = "/useful/colored", method = RequestMethod.GET)
    public String showUsefulColored(Model model, UtilityService utilityService) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @RequestMapping(path="/useful/email", method=RequestMethod.GET)
  public String validateEmail(Model model, @RequestParam(name = "email", required = false) String email) {
    model.addAttribute("emailAddress", email);
    model.addAttribute("emailIsValid", isEmailValid(email));
    return "email";
  }

  public boolean isEmailValid(String email) {
    if (email.contains(Character.toString('@')) && email.contains(Character.toString('.'))) {
      return true;
    }
    return false;
  }

  @RequestMapping(path="/encoder", method= RequestMethod.GET)
  public String encoder(Model model, UtilityService utilityService,
                        @RequestParam(name = "text", required = false) String textToEncode,
                        @RequestParam(name = "number", required = false) Integer number) {
    if (textToEncode != null && number != null) {
      model.addAttribute("codedText", utilityService.caesar(textToEncode, number));
      model.addAttribute("isNotNull", true);
    } else {
      model.addAttribute("isNotNull", false);
    }
    return "encode";
  }

  @RequestMapping(path="/decoder", method= RequestMethod.GET)
  public String decoder(Model model, UtilityService utilityService,
                        @RequestParam(name = "text", required = false) String textToDecode,
                        @RequestParam(name = "number", required = false) Integer number) {
    if (textToDecode != null && number != null) {
      model.addAttribute("codedText", utilityService.caesar(textToDecode, -number));
      model.addAttribute("isNotNull", true);
    } else {
      model.addAttribute("isNotNull", false);
    }
    return "decode";
  }
}
