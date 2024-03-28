package bitcamp.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource({
    "classpath:config/ncp.properties",
    "classpath:config/ncp-secret.properties"
})
@Controller
public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("과제관리 시스템 서버 실행!");
    // App.class 하위 모든 패키지에서 Component를 Scan한다.
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/home")
  public void home() {
    // return "home"; // ==> ThymeleafViewResolver가 처리한다.
  }

  @GetMapping("/about")
  public void about() {
  }
}
