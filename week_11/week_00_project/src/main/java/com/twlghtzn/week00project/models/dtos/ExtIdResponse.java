package com.twlghtzn.week00project.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExtIdResponse {
  private String imdb_id;
  private String facebook_id;
  private String instagram_id;
  private String twitter_id;
  private String id;

  public ExtIdResponse(String imdb_id, String facebook_id, String instagram_id,
                       String twitter_id, String id) {
    this.imdb_id = imdb_id;
    this.facebook_id = facebook_id;
    this.instagram_id = instagram_id;
    this.twitter_id = twitter_id;
    this.id = id;
  }
}
