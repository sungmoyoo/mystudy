

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0" metadata-complete="false">
<!--
schema 파일은 XML 태그 사용 규칙을 정의한 파일이다.
schema 파일(.xsd)은 복잡한 문법 = 복잡한 규칙을 정의한 것이며,
schemaLocation은 복잡한 규칙을 정의한 위치를 지정하는 것
DTD(.dtd)는 간결한 문법 = 단순한 규칙 정의한 것

schema 파일은 너무 복잡해서 전문 에디터를 사용

-->
  <description>
    스프링 Web MVC 프레임워크 예제 테스트
  </description>

  <display-name>java-spring-webmvc</display-name>

  <!--
   설정파일을 다음과 같이 config 아래에 두는 회사는 진지하게 퇴사 고민해라.
   왜? 일반 웹 디렉토리는 클라이언트에서 해당 경로로 접근이 가능하기 때문에
   설정 정보가 노출될 위험이 있다. 그래서 보안상 굉장이 취약하다.
   그래서 접근이 불가한 /WEB-INF 경로 하위에 설정파일을 두는 것이 권장된다.
   <param-value>/config/app-servlet.xml</param-value>
   -->

  <context-param>
    <param-name>contextClass</param-name>
    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
  </context-param>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>bitcamp.config.RootConfig</param-value>
  </context-param>

  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <servlet>
    <servlet-name>app</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextClass</param-name>
      <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>bitcamp.config.App2Config</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>app</servlet-name>
    <url-pattern>/app/*</url-pattern>
  </servlet-mapping>

  <servlet>
    <servlet-name>admin</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    <init-param>
      <param-name>contextClass</param-name>
      <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>bitcamp.config.App1Config</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>admin</servlet-name>
    <url-pattern>/admin/*</url-pattern>
  </servlet-mapping>

  <!--
   웹 애플리케이션이 시작될 때 사용자에게 표시될 기본 환영 페이지를 정의하는 코드
   -->
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>default.htm</welcome-file>
  </welcome-file-list>

</web-app>
-->














