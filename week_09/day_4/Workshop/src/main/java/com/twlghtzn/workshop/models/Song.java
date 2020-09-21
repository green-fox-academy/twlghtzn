package com.twlghtzn.workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "songs")
public class Song {
  @ManyToOne(cascade = CascadeType.REFRESH)
  private Author author;
  private String title;
  @ManyToOne(cascade = CascadeType.REFRESH)
  private Genre genre;
  @ManyToOne(cascade = CascadeType.REFRESH)
  private Year year;
  private int rating; //0-10, whole
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  @Id
  private long id;

  public Song() {
  }

  public Song(Author author, String title, Genre genre, Year year) {
    this.author = author;
    this.title = title;
    this.genre = genre;
    this.year = year;
    this.rating = 0;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
