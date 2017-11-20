package com.brajevicm.flow;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    19-Nov-17
 */
public class RegisterFlowHandler extends AbstractFlowHandler {

  @Override
  public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest request, HttpServletResponse response) {
    return "/register";
  }

  @Override
  public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response) {
    if (e instanceof NoSuchFlowExecutionException) {
      return "/register";
    } else {
      throw e;
    }
  }
}
