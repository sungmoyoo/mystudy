package bitcamp.myapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

  @RequestMapping("/home")
  public String home(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    return "/home.jsp";
  }
}
