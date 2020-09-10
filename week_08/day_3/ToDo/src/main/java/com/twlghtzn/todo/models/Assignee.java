package com.twlghtzn.todo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assignees")
public class Assignee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assId;
  private String name;
  private String email;
  @OneToMany
  private List<Todo> todos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Assignee() {
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  public Long getAssId() {
    return assId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
