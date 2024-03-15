package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_2")
public class Controller02_2 {

//  @RequestMapping // GET 요청일 때만 호출된다.
  @ResponseBody
  public String handler1() {
    return "get";
  }

//  @RequestMapping // POST 요청일 때만 호출된다.
  @ResponseBody
  public String handler2() {
    return "post";
  }
}
