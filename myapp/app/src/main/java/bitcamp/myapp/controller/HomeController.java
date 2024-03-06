package bitcamp.myapp.controller;

import bitcamp.util.Component;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HomeController {

  @RequestMapping("/home")
  public String home(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    return "/home.jsp";
  }
}
