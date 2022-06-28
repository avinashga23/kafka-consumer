package com.cisco.automation.cxpp.kafkaconsumer.controller;

import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Advice.
 */
@RestControllerAdvice
class Advice {

  /**
   * Handle exception string.
   *
   * @param exception the exception
   * @return the string
   */
  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  String handleException(ConstraintViolationException exception) {
    return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
        .collect(Collectors.joining());

  }

}
