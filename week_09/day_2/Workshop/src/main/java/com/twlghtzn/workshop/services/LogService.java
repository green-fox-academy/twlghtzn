package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.model.ArrayHandlerRequest;
import com.twlghtzn.workshop.model.Log;
import com.twlghtzn.workshop.model.LogResponse;
import com.twlghtzn.workshop.model.Until;
import com.twlghtzn.workshop.repositories.LogRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogService {
  private final LogRepository logRepository;

  public void addLog(LocalDateTime createdAt, String endpoint, String data) {
    logRepository.save(new Log(createdAt, endpoint, data));
  }

  public List<Log> getAllLogs() {
    return logRepository.findAll();
  }

  public int countLogs() {
    return (int) logRepository.count();
  }

  public String requestToString(ArrayHandlerRequest arrayHandlerRequest) {
    return "action=" + arrayHandlerRequest.getWhat() +
        ", numbers=" + arrayHandlerRequest.getNumbers().toString();
  }

  public String untilToString(String action, Until until) {
    return "action=" + action + ", until=" + String.valueOf(until.getUntil());
  }

  public String appendAToString(String name, String title) {
    return "name=" + name + ", title=" + title;
  }

  public LogResponse getLogResponse() {
    return new LogResponse(getAllLogs(), countLogs());
  }
}
