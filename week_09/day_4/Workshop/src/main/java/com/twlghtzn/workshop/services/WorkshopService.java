package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.models.GrootBadRequestResponse;
import com.twlghtzn.workshop.models.GrootOKResponse;
import com.twlghtzn.workshop.models.YonduBadRequestResponse;
import com.twlghtzn.workshop.models.YonduOKResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopService {

  @Autowired
  public WorkshopService() {
  }

  public GrootOKResponse getAGrootOKResponse(String message) {
    return new GrootOKResponse(message);
  }

  public GrootBadRequestResponse getAGrootBadRequestResponse() {
    return new GrootBadRequestResponse();
  }

  public YonduOKResponse getAYonduOKResponse(double distance, double time) {
    return new YonduOKResponse(distance, time);
  }

  public YonduBadRequestResponse getAYonduBadRequestResponse() {
    return new YonduBadRequestResponse();
  }
}
