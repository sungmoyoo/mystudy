package bitcamp.myapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class AboutController {

  public AboutController() {
    System.out.println("AboutController() 호출됨");
  }

  @RequestMapping("/about")
  public String about(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    return "/about.jsp";
  }
}
