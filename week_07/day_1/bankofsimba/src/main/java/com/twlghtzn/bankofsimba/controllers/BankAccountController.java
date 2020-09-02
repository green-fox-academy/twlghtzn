package com.twlghtzn.bankofsimba.controllers;

import com.twlghtzn.bankofsimba.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankAccountController {
  List<BankAccount> bankAccounts;

  public BankAccountController() {
    this.bankAccounts = new ArrayList<>();
    bankAccounts.add(new BankAccount
        ("Simba", 2000, "lion", true, true));
    bankAccounts.add(new BankAccount
        ("Zordon", 8000, "lion", false, false));
    bankAccounts.add(new BankAccount
        ("Rafiki", 3000, "monkey", false, true));
    bankAccounts.add(new BankAccount
        ("Timon", 1000, "meerkat", false, true));
    bankAccounts.add(new BankAccount
        ("Pumba", 4000, "warthog", false, true));
  }

  BankAccount simba = new BankAccount
      ("Simba", 2000, "lion", true, true);

  @RequestMapping(path = "/show", method = RequestMethod.GET)
  public String showSimba(Model model) {
    model.addAttribute("simba", simba);
    return "show";
  }

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String welcomePage(Model model) {
    String greeting = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("greeting", greeting);
    return "greeting";
  }

  @RequestMapping(path = "/all-bankaccounts", method = RequestMethod.GET)
  public String showAllBankAccounts(Model model) {
    model.addAttribute("bankAccounts", bankAccounts);
    return "allbankaccounts";
  }

  @PostMapping(path = "/raise")
  public String raiseBalance(Model model, @RequestParam(name = "index") int index) {
    if (bankAccounts.get(index).isKing()) {
      bankAccounts.get(index).setBalance(bankAccounts.get(index).getDoubleBalance() + 100);
    } else {
      bankAccounts.get(index).setBalance(bankAccounts.get(index).getDoubleBalance() + 10);
    }
    model.addAttribute("bankAccount", bankAccounts.get(index));
    return "redirect:/all-bankaccounts";
  }

  @PostMapping(path = "/add")
  public String addBankAccount(Model model, @RequestParam(name = "name") String name,
                               @RequestParam(name = "type") String type) {
    bankAccounts.add(new BankAccount(name, 0, type, false, true));
    model.addAttribute("bankAccounts", bankAccounts);
    return "redirect:/all-bankaccounts";
  }
}
