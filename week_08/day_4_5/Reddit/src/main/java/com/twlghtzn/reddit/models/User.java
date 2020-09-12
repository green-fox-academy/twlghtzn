package com.twlghtzn.reddit.models;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

  @Column
  private String name;
  private String password;
  @OneToMany(mappedBy = "author", cascade = CascadeType.REFRESH)
  private List<Post> posts;
  @ManyToMany(mappedBy = "usersVotedUp", fetch = FetchType.LAZY)
  private List<Post> upvotedPosts;
  @ManyToMany(mappedBy = "usersVotedDown", fetch = FetchType.LAZY)
  private List<Post> downvotedPosts;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    posts = new ArrayList<>();
    upvotedPosts = new ArrayList<>();
    downvotedPosts = new ArrayList<>();
  }
}
