package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan("bitcamp.app1")
public class App1Config {
  // 얘를 사용하려면 라이브러리 받아와야 함, 하는 역할은 customizeRegistration 메서드와 동일하다.
//  @Bean
//  MultipartResolver multipartResolver() {
//    StandardServletMultipartResolver mr = new StandardServletMultipartResolver();
//
//    return mr;
//  }
}
