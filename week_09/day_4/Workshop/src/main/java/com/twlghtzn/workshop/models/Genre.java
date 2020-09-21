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
@Table(name = "genres")
@Entity
public class Genre {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @JsonIgnore
  private long id;
  private String name;
  @JsonIgnore
  @OneToMany(mappedBy = "genre", cascade = CascadeType.REFRESH)
  private List<Song> songs;

  public Genre() {
  }

  public Genre(String name) {
    this.name = name;
    songs = new ArrayList<>();
  }
}
