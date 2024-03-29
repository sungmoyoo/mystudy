package bitcamp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml 이나 애노테이션이 아닌 다른 방법으로 서블릿을 등록하기
// => Servlet API의 표준 기술 활용!

// 서블릿 컨테이너가 시작될 때 보고 받는 객체
// 구동 순서:
// 1) 서블릿 컨테이너를 시작한다.
// 2) 서블릿 컨테이너는 /WEB-INF/lib/*.jar 파일을 뒤진다.
// 3) /META-INF/services/javax.servlet.SerlvetContainerInitializer 파일을 찾는다.
// 4) 그 파일에서 ServletContainerInitializer 구현체를 알아낸다.
// 5) 해당 구현체의 인스턴스를 생성한 후 onStartup()을 호출한다.
// 6) 만약 그 구현체가 보고 받고자 하는 타입이 있다면 해당 클래스를 찾아
//    onStartup()을 호출할 때 파라미터로 넘겨준다.
//
// WebApplicationInitializer 호출 과정
// 1) 서블릿 컨테이너(예: 톰캣 서버)를 시작한다.
// 2) spring-web-*.jar 파일에서
//    /META-INF/service/javax.servlet.SerlvetContainerInitializer 파일을 읽는다.
// 3) 이 파일에 등록된 클래스의 인스턴스를 생성한다.
//    => SpringServletContainerInitializer 인스턴스 생성
// 4) SpringServletContainerInitializer 객체에 대해 onStartup()을 호출한다.
//    => 호출할 때 WebApplicationInitializer를 구현한 클래스 목록을 넘겨준다.
// 5) SpringServletContainerInitializer는
//    WebApplicationInitializer 구현체의 인스턴스를 만들고,
//    onStartup()을 호출한다.
//
public class App2WebApplicationInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {App2Config.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app2/*"};
  }

  @Override
  protected String getServletName() {
    return "app2";
  }
}