package com.twlghtzn.todo.models;

import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
  @Column(name = "todo_name")
  private String name;
  private boolean isComplete;
  private boolean isUrgent;
  @ManyToOne
  private Assignee assignee;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Todo() {
  }

  public Todo(String name) {
    this.name = name;
    this.isComplete = false;
    this.isUrgent = false;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
      this.assignee = assignee;
      assignee.getTodos().add(this);
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setUrgent(boolean urgent) {
    isUrgent = urgent;
  }

  public Long getId() {
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
