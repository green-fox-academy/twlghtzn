package com.twlghtzn.week00project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Table(name = "users")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;
  private String userName;
  private String password;

  public User(String userName, String password) {
    this.userName = userName;
    this.password = BCrypt.hashpw(password, BCrypt.gensalt());
  }
}
