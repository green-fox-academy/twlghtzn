package com.twlghtzn.todo.models;

public class Todo {
  private String name;
  private boolean isComplete;
  private int id;

  public Todo(String name, int id) {
    this.name = name;
    this.isComplete = false;
    this.id = id;
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
