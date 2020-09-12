package com.twlghtzn.reddit.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

  @ManyToMany(cascade = CascadeType.REFRESH)
  List<User> usersVotedUp;
  @ManyToMany(cascade = CascadeType.REFRESH)
  List<User> usersVotedDown;
  @Column
  private int score;
  private LocalDateTime date;
  private String url;
  private String title;
  @ManyToOne(fetch = FetchType.LAZY)
  private User author;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  public Post(String title, String url, User author) {
    this.url = url;
    this.author = author;
    this.date = LocalDateTime.now();
    usersVotedDown = new ArrayList<>();
    usersVotedUp = new ArrayList<>();
    this.title = title;
  }

  public String getTimeStamp(LocalDateTime date) {
    String ldt = String.valueOf(date.truncatedTo(ChronoUnit.MINUTES));
    return ldt.replace('T', ' ');
  }

  public String getDate() {
    return getTimeStamp(this.date);
  }

  public String getAuthorName() {
    return getAuthor().getName();
  }
}
