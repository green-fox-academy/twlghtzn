package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.model.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ErrorMessageService {
  private final List<ErrorMessage> errors;

  public ErrorMessageService() {
    this.errors = new ArrayList<>();
    errors.add(0, new ErrorMessage("Please provide an input!"));
    errors.add(1, new ErrorMessage(("Please provide a name and a title!")));
    errors.add(2, new ErrorMessage("Please provide a title!"));
    errors.add(3, new ErrorMessage("Please provide a name!"));
    errors.add(4, new ErrorMessage("Please provide a number!"));
    errors.add(5, new ErrorMessage("Please provide what to do with the numbers!"));
  }

  public List<ErrorMessage> getErrors() {
    return errors;
  }
}
