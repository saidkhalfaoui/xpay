package com.henripay.henripayapi.handler;

import org.camunda.bpm.engine.ProcessEngineException;

public class MyException extends ProcessEngineException {

  public MyException(String message, int code) {
    super(message, code);
  }
}
