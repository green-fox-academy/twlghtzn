package com.twlghtzn.todo.services;

import com.twlghtzn.todo.models.Todo;
import com.twlghtzn.todo.repositories.TodoRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository todoRepository;


  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Iterable<Todo> getTodos() {
    return todoRepository.findAll();
  }

  public void addTodo(Todo newTodo) {
    if (newTodo.getName() != null) {
      todoRepository.save(newTodo);
    }
  }

  public void completeTodo(Long id) {
    todoRepository.findById(id).orElse(null).setComplete(true);
  }

  public void deleteTodoById(Long id) {
    todoRepository.delete(todoRepository.findById(id).orElse(null));
  }

/*  public Todo findTodoById(Long id) {
    return todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
  } */
}
