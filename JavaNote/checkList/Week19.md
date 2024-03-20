# 학습점검목록 19주차

# 85일차(2024-03-18, 월)
### 1. request handler의 파라미터로 다룰 수 있는 타입을 설명할 수 있는가?
ServletRequest, HttpServletRequest, ServletResponse, HttpServletResponse, HttpSession, Map, Model 등이 있다. 단 ServletContext, ApplicationContext는 파라미터로 다룰 수 없어 의존 객체로 주입받아야 한다.

### 2. @RequestParam 사용법을 설명할 수 있는가?
클라이언트가 보낸 파라미터 값을 지정한 이름으로 받을 수 있는 애노테이션이다. 요청 파라미터 이름과 메서드 파라미터(아규먼트) 이름이 같은 경우 생략할 수 있다.

### 3. request handler에서 요청 파라미터 값을 객체로 받는 방법을 아는가?

### 4. 객체가 포함하고 있는 객체에 요청 파라미터 값을 받는 방법을 아는가?

### 5. 프로퍼티 에디터를 사용하여 요청 파라미터의 문자열을 다른 타입으로 변환할 수 있는가?

### 6. @ControllerAdvice, @InitBinder 사용법을 설명할 수 있는가?

### 7. @RequestHeader 사용법을 아는가?

### 8. User-Agent 요청 헤더를 다룰 수 있는가?

### 9. @CookieValue를 사용하여 쿠키를 다룰 수 있는가?
쿠키를 클라이언트로 보내는 방법은 response 객체를 주입받아 addCookie를 통해 추가하는 방법밖에 없다.

### 10. multipart/form-data 형식의 요청 파라미터 값을 다룰 수 있는가?

### 11. @RequestBody/@ResponseBody 사용법을 아는가?
@RequestBody 클라이언트가 보낸 데이터를 통째로 받을 때 사용하는 애노테이션이다.  
@ResponseBody는 클라이언트로 view URL이 아닌 클라이언트에게 데이터를 직접 보낼 때 사용한다.

### 12. request handler의 리턴 타입으로 String, HttpEntity, ResponseEntity를 사용하는 방법을 아는가?

### 13. request handler에서 View URL을 리턴하는 방법을 아는가?
@ResponseBody를 붙이지 않고 String을 보내면 프론트 컨트롤러가 view URL로 인식한다


# 86일차(2024-03-19, 화)
### 1. request handler에서 redirect, forward, include를 처리하는 방법을 설명할 수 있는가?

### 2. request handler에서 뷰 컴포넌트가 사용할 값을 리턴하는 방법을 설명할 수 있는가?

### 3. ViewResolver의 역할과 동작과정을 설명할 수 있는가?

### 4. view name이 절대 경로일 때와 상대 경로일 때에 따라 URL의 계산 달라지는 것을 설명할 수 있는가?

### 5. @PathVariable을 사용하여 URL에서 값을 추출하는 방법을 설명할 수 있는가?

### 6. @MatrixVariable 사용법을 설명할 수 있는가?


