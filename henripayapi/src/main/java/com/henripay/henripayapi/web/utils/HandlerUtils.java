package com.henripay.henripayapi.web.utils;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.util.Optional;

public class HandlerUtils {

    public static void throwBpmnError(DelegateExecution execution, String message) {
        execution.setVariable("bpmnError", "TransactionFailed");
        execution.setVariable("bpmnErrorMessage", message);
        throw new BpmnError("TransactionFailed", message);
    }

    public static <T> void throwBpmnErrorIsEmpty(DelegateExecution execution, Optional<T> data, String message) {
        if (data.isPresent())
            return;
        //
        throwBpmnError(execution, message);
    }
}
