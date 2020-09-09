package com.twlghtzn.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
  @Column(name = "todo_name")
  private String name;
  private boolean isComplete;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  public Todo() {
  }

  public Todo(String name) {
    this.name = name;
    this.isComplete = false;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public void setComplete(boolean complete) {
    isComplete = complete;
  }
}
