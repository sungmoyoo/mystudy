# JSP 태그
- directive element
<%@ page --- %> : JSP 페이지 설정
<%@ include ---%> : 다른 파일의 콘텐트를 삽입
<%@ taglib --- %> : 외부 태그를 가져오기

- scriptlit
<% 자바 코드 %> : 

# EL(Expression Language)
>객체 관계(그래프)를 따라가는 문법, 탐색하고 조작하는 문법

 $ {객체, 프로퍼티, 프로퍼티 ...} <- OGNL(Object Graph Navigation Language) 표기법을 이용하여 값을 다룬다.



*OGNL의 객체 Graph  의미: 객체 간의 관계를 도식으로 보여주는 것, 객체들 간의 연결된 네트워크로, 하나의 객체가 다른 객체를 참조하고 있고, 그 객체가 또 다른 객체를 참조하는 형태로 이어진 구조

```java
class Car {
  Engine engine;
}

class Engine {
  Maker maker;
}

class Maker {
  String name
}

Car c = new Car();

c.engine.maker.name
```

# Front Controller
웹 개발에서 사용되는 디자인 패턴, 모든 요청을 처리하는 애플리케이션의 단일 진입점 역할을 한다. 


# 상대경로
`/`가 없으면 상대경로를 가리킨다. 현재 웹브라우저의 경로를 기준으로 계산한다. 예를 들면 /assignment/list 에서 경로를 지정할 때 `/`를 앞에 붙이지 않으면 현재 경로 뒤에 이어 붙는다.
`/`를 붙이면 포트번호 뒤(절대경로 위치)에 주소가 붙는다. 
