package com.twlghtzn.todo.services;

import com.twlghtzn.todo.models.Todo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private List<Todo> todos;
  private int nextId;

  public TodoService() {
    this.todos = new ArrayList<>();
    this.nextId = 1;
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public void addTodo(String name) {
    todos.add(new Todo(name, nextId));
    nextId++;
  }

  public void completeTodo(String name) {
    findTodo(name).setComplete(true);
  }

  public void deleteTodo(String name) {
    if (todos.size() != 0 && findTodo(name) != null) {
      todos.remove(findTodo(name));
    }
  }

  public Todo findTodo(String name) {
    for (Todo todo: todos) {
      if (todo.getName().equals(name)) {
        return todo;
      }
    }
    return null;
  }
}
