package com.twlghtzn.week00project.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TokenResponse {
  private boolean success;
  private String expires_at;
  private String request_token;

  public TokenResponse(boolean success, String expires_at, String request_token) {
    this.success = success;
    this.expires_at = expires_at;
    this.request_token = request_token;
  }
}
