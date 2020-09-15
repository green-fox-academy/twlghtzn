package com.twlghtzn.workshop.model;

import java.util.List;

public class LogResponse {
  private final List<Log> entries;
  private final int entry_count;

  public LogResponse(List<Log> entries, int entry_count) {
    this.entries = entries;
    this.entry_count = entry_count;
  }

  public List<Log> getEntries() {
    return entries;
  }

  public int getEntry_count() {
    return entry_count;
  }
}
