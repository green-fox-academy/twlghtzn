package com.twlghtzn.todo.controllers;

import com.twlghtzn.todo.models.Assignee;
import com.twlghtzn.todo.repositories.AssigneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AssigneeController {
  private final AssigneeRepository assigneeRepository;

  @RequestMapping(path= "/assignees", method = RequestMethod.GET)
  public String showAssignees(Model model) {
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "assignees";
  }

  @PostMapping(path = "/assignees")
  public String addTodo(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email) {
    assert assigneeRepository != null;
    assigneeRepository.save(new Assignee(name, email));
    return "redirect:/assignees";
  }
}
