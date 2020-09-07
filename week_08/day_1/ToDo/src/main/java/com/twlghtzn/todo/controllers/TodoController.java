package com.twlghtzn.todo.controllers;

import com.twlghtzn.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping(path = "/todo", method = RequestMethod.GET)
  public String showTodos(Model model) {
    model.addAttribute("todos", todoService.getTodos());
    return "index";
  }

  @PostMapping(path = "/todo")
  public String addTodo(@RequestParam(name = "newTodo") String todoName) {
    todoService.addTodo(todoName);
    return "redirect:/todo";
  }

  @PostMapping(path = "/complete")
  public String completeTodo(@RequestParam(name = "name") String name) {
    todoService.completeTodo(name);
    return "redirect:/todo";
  }

  @PostMapping(path = "/delete")
  public String deleteTodo(@RequestParam(name = "name") String name) {
    todoService.deleteTodo(name);
    return "redirect:/todo";
  }
}

