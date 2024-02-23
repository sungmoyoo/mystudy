# Refresh 

> 클라이언트에게 다른 URL을 요청하라는 명령

서버로부터 응답을 받고 "내용을 출력한 후" 지정된 시간이 경과되면 특정 URL을 자동으로 요청하도록 만들 수 있다.

## Refresh 방법

**헤더에 명령 추가**
out.println()이 출력한 후 상태는 버퍼 스트림에 보관한 상태이고 service() 메서드 호출이 끝나면 버퍼를 message-body에 담아 응답한다. 따라서 순서 상관없이 응답 헤더에 Refresh 정보를 추가하여 리프래시를 실행할 수 있다. 
```java
// Refresh 응답 헤더에 설정된 시간이 지난 후 알려준 url을 자동 요청한다.
response.setHeader("Refresh", "3;url=s100");
```

**HTML 헤더에 Refresh 명령 추가**
HTML을 출력하는 경우 응답헤더가 아니라 HTML 헤더에 리프래시 명령을 설정할 수 있다. 
```java
// http-equiv : 응답 헤더와 유사한 동작을 하는데 사용
out.println("<meta http-equiv='Refresh' content='3;url=s100'>");
```

# Redirect
> 응답할 때 콘텐트를 보내지 않는다. 바로 다른 페이지를 요청하라고 명령한다.

Redirect는 Servlet에서 작업 후 응답할 때 다시 요청할 url만 포함하고 콘텐트는 포함하지 않는다. 

*Redirect 응답 예
```
HTTP/1.1 302 
Location: s100
Content-Type: text/html;charset=UTF-8
Content-Length: 0
Date: Fri, 23 Feb 2024 05:41:30 GMT
Keep-Alive: timeout=60
Proxy-Connection: keep-alive

// message-body가 없다.
```

```java
// 클라이언트에게 URL을 알려줄 때 상대 경로를 지정할 수 있다.
// forward/include 와 달리 '/'는 컨텍스트 루트(웹 애플리케이션 루트)가 아닌
// 웹 서버 루트를 의미한다.
response.sendRedirect("s100");
```

- 로그인 후 로그인 결과를 출력하지 않고 즉시 메인 화면으로 보내고 싶을 때
- 결제완료 후 결과를 출력하지 않고 즉시 결제 상태 페이지로 보내고 싶을 때
- 게시글 삭제 후 결과를 출력하지 않고 즉시 게시글 목록으로 보내고 싶을 때

### *버퍼와 응답
Refresh와 Redirect의 설정의 위치는 출력문이 어디에 있던 상관없다. 다만 출력 시 버퍼가 가득 차면 즉시 응답하기 때문에 리프래시가 동작하지 않는 것에 유의해야 한다(1요청=1응답). 물론 Redirect는 응답문을 작성하지 않는 것이 원칙이다.(어차피 모두 버려지기 때문)

