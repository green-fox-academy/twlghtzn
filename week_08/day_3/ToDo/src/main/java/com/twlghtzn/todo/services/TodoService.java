package com.twlghtzn.todo.services;

import com.twlghtzn.todo.models.Todo;
import com.twlghtzn.todo.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {
  private final TodoRepository todoRepository;

  public Iterable<Todo> getTodos() {
    return todoRepository.findAll();
  }

  public void addTodo(Todo newTodo) {
    if (newTodo.getName() != null) {
      todoRepository.save(newTodo);
    }
  }

  public void reverseDone(Long id) {
    if (todoRepository.findById(id).orElse(null).isComplete()) {
      todoRepository.findById(id).orElse(null).setComplete(false);
    } else {
      todoRepository.findById(id).orElse(null).setComplete(true);
    }
    todoRepository.save(todoRepository.findById(id).orElse(null));
  }

  public void reverseUrgent(Long id) {
    if (todoRepository.findById(id).orElse(null).isUrgent()) {
      todoRepository.findById(id).orElse(null).setUrgent(false);
    } else {
      todoRepository.findById(id).orElse(null).setUrgent(true);
    }
    todoRepository.save(todoRepository.findById(id).orElse(null));
  }

  public void completeTodo(Long id) {
    todoRepository.findById(id).orElse(null).setComplete(true);
  }

  public void deleteTodoById(Long id) {
    todoRepository.delete(todoRepository.findById(id).orElse(null));
  }
}
