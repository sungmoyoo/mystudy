package bitcamp.myapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class HomeController {

  public HomeController() {
    System.out.println("HomeController() 호출됨");
  }

  @RequestMapping("/home")
  public String home(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    return "/home.jsp";
  }
}
