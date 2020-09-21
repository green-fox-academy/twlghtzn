package com.twlghtzn.workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "authors")
public class Author {
  private String name;
  @JsonIgnore
  @OneToMany(mappedBy = "author", cascade = CascadeType.REFRESH)
  private List<Song> songs;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  @Id
  private long id;

  public Author() {
  }

  public Author(String name) {
    this.name = name;
    songs = new ArrayList<>();
  }
}
