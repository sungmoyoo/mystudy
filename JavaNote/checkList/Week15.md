# 학습점검목록 15주차

# 66일차(2024-02-19, 월)
### 1. ServlerContextListener를 설명할 수 있는가?
  웹 애플리케이션이 시작되거나 종료될 때 어떤 메서드를 호출할 지 정의한 규칙
### 2. ServletContext 저장소를 설명할 수 있는가?

### 3. ServletContextListener를 구현하고 배포할 수 있는가?

### 4. ServletContext에 공유 객체를 저장하고 꺼내서 사용할 수 있는가?


# 67일차 (2024-02-20, 화)
### 1. HTML, HTTP 즉 Web 기술의 등장을 설명할 수 있는가?

### 2. 웹 기술이 활용되어 온 과정을 설명할 수 있는가?

### 3. CGI를 설명할 수 있는가?

### 4. CGI 프로그램을 개발할 때 스크립트 언어를 주로 사용하는 이유를 설명할 수 있는가?
인터프리터 방식이라 변경 후 따로 처리를 할 필요가 없다. 그리고 텍스트 처리가 쉬워 CGI 프로그램 개발에 적합하다.

### 5. C/S 아키텍처와 Web App. Server 아키텍처를 설명할 수 있는가?

### 6. 모놀리식 아키텍처와 마이크로서비스 아키텍처를 설명할 수 있는가?

### 7. JavaEE에 대해 설명할 수 있는가?

### 8. 기업용 프로그램을 설명할 수 있는가?

### 9. Servlet 기술과 EJB 기술을 설명할 수 있는가?
Servlet은 웹 컴포넌트를 만드는 기술, EJB는 분산 컴포넌트를 만드는 기술

### 10. RESTful 기술을 설명할 수 있는가?
웹 컴포넌트를 원격 객체로 만드는 기술, 즉 기존의 웹 기술을 그대로 활용해서 원격 객체 서비스를 제공하는 기술.

### 11. 원격 메서드 호출 기술에 대해 이해하는가?

### 12. JavaEE 와 구현 서버에 대해 설명할 수 있는가?

### 13. JavaEE 구현 서버와 Servlet Container의 차이를 설명할 수 있는가?

### 14. JavaEE와 JakartaEE의 관계를 설명할 수 있는가?

### 15. 자바 웹 프로젝트를 생성하고 톰캣 서버를 기본 장착하여 실행할 수 있는가?


# 68일차 (2024-02-22, 수)
### 1. Serverside Rendering과 ClientSide Rendering을 설명할 수 있는가?

### 2. Servlet 인터페이스와 GenericServlet/HttpServlet 추상클래스를 설명할 수 있는가?
- Servlet Container가 호출할 수 있도록 정의한 규칙이 Servlet 인터페이스이다. 
- GenericServlet은 Servlet의 service()를 제외한 메서드를 구현한 클래스
- HttpServlet은 HTTP 프로토콜 다루는 메서드를 사용하기 위해 하위 레퍼런스로 형변환해주는 클래스.

#### 2.1 GenericServlet을 상속받아서 서블릿을 만들 수 있는가? 

#### 2.2 HttpServlet을 상속받아서 서블릿을 만들 수 있는가?

### 3. 서블릿 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?

### 4. DD 파일을 설명할 수 있는가?
Deployment Descriptor,웹 애플리케이션의 배치정보를 서술한 파일

### 5. 서블릿 배치 방법을 설명할 수 있는가?
애노테이션, XML

### 6. Filter 인터페이스를 설명할 수 있는가?
- init(), doFilter(), destroy() 메서드 가짐.


### 7. 필터의 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?
- 애플리케이션이 실행될 때 생성되고 생성되자마자 init()가 호출된다.

### 8. 필터 배치 방법을 설명할 수 있는가?

### 9. 필터의 동작 과정을 설명할 수 있는가?

### 10. GoF의 Chain Of Responsibility 패턴을 필터를 이용하여 설명할 수 있는가?

### 11. XxxListener 인터페이스를 설명할 수 있는가?

### 12. 리스너 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?

### 13. GoF Observer 패턴을 리스너를 이용하여 설명할 수 있는가?


# 69일차(2024-02-23, 목)
### 1. 서블릿에서 텍스트를 웹브라우저로 보낼 수 있는가?

### 2. 텍스트를 출력할 때 한글이 깨지는 이유를 설명할 수 있는가?

### 3. 서블릿에서 바이너리 데이터를 웹브라우저로 보낼 수 있는가?

### 4. POST 방식으로 전달된 파라미터의 한글 데이터가 깨지는 이유를 설명할 수 있는가?

### 5. HTTP 프로토콜에서 요청할 때 규칙과 응답할 떄 규칙을 설명할 수 있는가?

### 6. GET 방식과 POST 방식의 특징을 설명할 수 있는가?

### 7. 파일 업로드를 구현할 수 있는가?


# 70일차(2024-02-24, 금)
### 1. GET/POST 프로토콜의 특징을 이해하고 프로젝트에 적용할 수 있는가?

### 2. refresh와 redirect의 특징을 설명할 수 있는가?

### 3. forward/include의 특징을 설명할 수 있는가?
