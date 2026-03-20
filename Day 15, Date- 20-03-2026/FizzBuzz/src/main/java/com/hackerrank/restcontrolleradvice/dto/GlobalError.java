package com.hackerrank.restcontrolleradvice.dto;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalError {
  private String message;
  private String errorReason;

  public GlobalError() {
  }

  public GlobalError(String message, String errorReason) {
    this.message = message;
    this.errorReason = errorReason;
  }




  public void setMessage(String message) {
    this.message = message;
  }

  public void setErrorReason(String errorReason) {
    this.errorReason = errorReason;
  }

  public String getMessage() {
    return message;
  }

  public String getErrorReason() {
    return errorReason;
  }

}
