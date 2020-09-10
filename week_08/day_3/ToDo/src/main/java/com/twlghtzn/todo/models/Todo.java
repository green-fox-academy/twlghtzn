package com.twlghtzn.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

  public Todo(String name) {
    this.name = name;
    this.isComplete = false;
    this.isUrgent = false;
  }
}
