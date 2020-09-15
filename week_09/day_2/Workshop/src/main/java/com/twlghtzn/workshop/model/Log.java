package com.twlghtzn.workshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "logs")
@Entity
public class Log {
  @JsonIgnore
  private LocalDateTime createdAt;
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;
  @Column
  private String endpoint;
  @Column
  private String data;

  public Log() {
  }

  public Log(LocalDateTime createdAt, String endpoint, String data) {
    this.createdAt = createdAt;
    this.endpoint = endpoint;
    this.data = data;
  }

  public long getId() {
    return id;
  }

  public String getCreatedAt() {
    return getTimeStamp(createdAt);
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getTimeStamp(LocalDateTime date) {
    String ldt = String.valueOf(date.truncatedTo(ChronoUnit.MINUTES));
    return ldt.replace('T', ' ');
  }

  public String getData() {
    return data;
  }
}