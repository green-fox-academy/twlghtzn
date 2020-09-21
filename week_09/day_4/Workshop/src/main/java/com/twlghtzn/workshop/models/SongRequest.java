package com.twlghtzn.workshop.models;

public class SongRequest {
  private String author;
  private String title;
  private String genre;
  private Integer year;

  public SongRequest(String author, String title, String genre, Integer year) {
    this.author = author;
    this.title = title;
    this.genre = genre;
    this.year = year;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public Integer getYear() {
    return year;
  }
}
