package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("c04_6")
public class Controller04_6 {
  @GetMapping("h1")
  @ResponseBody
  public void handler1(
      PrintWriter out,
      @RequestHeader("Accept") String accept,
      @RequestHeader("User-Agent") String userAgent) {

    out.printf("Accept=%s\n", accept);
    out.printf("User-Agent=%s\n", userAgent);

    // 조건을 검사할 때 순서가 매우 중요하다.
    // why? User-Agent에 다른 브라우저 이름을 가지고 있기 때문이다.
    // 예를 들면 아랍식 이름처럼, 해당 브라우저를 만들 때 사용한 다른 브라우저의 오픈소스 이름을
    // 기재하기 때문에 크롬, 사파리 이름을 먼저 검사하면 안된다.
    // ex) User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36
    if (userAgent.matches(".*Edg.*")) {
      out.println("Edge");
    } else if (userAgent.matches(".*Chrome.*")) {
      out.println("chrome");
    } else if (userAgent.matches(".*Safari.*")) {
      out.println("safari");
    } else if (userAgent.matches(".*Firefox.*")) {
      out.println("firefox");
    } else {
      out.println("etc");
    }
  }
}
