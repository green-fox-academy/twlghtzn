package com.twlghtzn.todo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
}
