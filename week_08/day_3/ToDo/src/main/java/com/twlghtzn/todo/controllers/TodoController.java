package com.twlghtzn.todo.controllers;

import com.twlghtzn.todo.models.Todo;
import com.twlghtzn.todo.repositories.AssigneeRepository;
import com.twlghtzn.todo.repositories.TodoRepository;
import com.twlghtzn.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
  private TodoService todoService;
  private AssigneeRepository assigneeRepository;
  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoService todoService, AssigneeRepository assigneeRepository, TodoRepository todoRepository) {
    this.todoService = todoService;
    this.assigneeRepository = assigneeRepository;
    this.todoRepository = todoRepository;
  }

  @RequestMapping(path = "/todo", method = RequestMethod.GET)
  public String showTodos(Model model) {
    model.addAttribute("todos", todoService.getTodos());
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "index";
  }

  @PostMapping(path = "/todo")
  public String addTodo(@RequestParam(name = "newTodo") String todoName) {
    todoService.addTodo(new Todo(todoName));
    return "redirect:/todo";
  }

  @PostMapping(path = "/todo/setassignee")
  public String setAssigneeForTodo(@RequestParam(name = "todoId") Long todoId, @RequestParam(name="assignee") Long assId) {
    Todo todo = todoRepository.findById(todoId).orElse(null);
    todo.setAssignee(assigneeRepository.findById(assId).orElse(null));
    todoRepository.save(todo);
    return "redirect:/todo";
  }

  @PostMapping(path = "/complete")
  public String completeTodo(@RequestParam(name = "id") Long id) {
    todoService.completeTodo(id);
    return "redirect:/todo";
  }

  @PostMapping(path = "/delete")
  public String deleteTodo(@RequestParam(name = "id") Long id) {
    todoService.deleteTodoById(id);
    return "redirect:/todo";
  }

  @ResponseBody
  @RequestMapping(path = "/list", method = RequestMethod.GET )
  public String list() {
    return "This is my first Todo";
  }
}
