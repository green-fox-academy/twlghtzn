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
@Table(name = "years")
@Entity
public class Year {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @JsonIgnore
  private long id;
  private int year;
  @JsonIgnore
  @OneToMany(mappedBy = "year", cascade = CascadeType.REFRESH)
  private List<Song> songs;

  public Year() {
  }

  public Year(int year) {
    this.year = year;
    songs = new ArrayList<>();
  }
}
