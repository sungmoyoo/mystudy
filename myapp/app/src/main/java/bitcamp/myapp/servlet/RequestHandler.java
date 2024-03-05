package bitcamp.myapp.servlet;

import java.lang.reflect.Method;

public class RequestHandler {

  Method handler;
  Object controller;

  public RequestHandler() {
  }

  public RequestHandler(Method handler, Object controller) {
    this.handler = handler;
    this.controller = controller;
  }
}
