## 8 -> 9

## 9 -> 10
- CRUD 구현  
  xxxMenu에 메서드 구현
  - add()
  - list()
  - view()
  - modify()
  - delete()

## 10 -> 11
- 사용자 정의 데이터 타입 용도의 클래스 생성
- board, assignment, member에서 사용할 클래스 생성 후 객체를 생성하여 사용

## 11 -> 12
- 레퍼런스 배열 다루기
- 입력값(객체)을 저장하는 레퍼런스 배열을 생성, 확장, 조회, 출력하는 기능 구현

## 12 -> 13
- 회원 메뉴 추가하고 CRUD 구현  
  xxxMenu에 메서드 구현, 10번과 동일
  - add()
  - list()
  - view()
  - modify()
  - delete()


## 13 -> 14
- 스태틱 필드 한계 확인
- 변경사항 없음

## 14 -> 15
- BoardMenu, AssignmentMenu, MemberMenu에 인스턴스 메서드 적용
- Prompt에 inputInt(), inputFloat(), inputBoolean() 메서드 추가
- 생성자를 통해 Prompt 객체를 XxxMenu에 주입
- ANSI Escape Sequence 값을 별도의 클래스로 분리
- 클래스를 패키지로 분류

## 15 -> 16
- 인터페이스 문법으로 메뉴를 다루는 객체의 실행 규칙 정의 (Menu ...)
- 인터페이스에 정의한 대로 메뉴를 다루는 객체를 구현 (App)
- 인터페이스에 정의한 대로 메뉴를 다루는 객체를 실행 (mainMenu.execute)


## 16 -> 17 
- Menu, MenuHandler 인터페이스 추가
- Menu: MenuGroup, MenuItem
- MenuHandler: 각종 핸들러들
 
### 인터페이스
Menu: execute(Prompt prompt), String getTitle()

Menuhandler: action()


MenuGroup: 생성자(title), menuSize, menus배열
execute(), printMenu(), getTitle(), add(), remove(), indexOf()

MenuItem: 생성자(title), 생성자(title, menuHandler), title, menuHandler
execute(), getTitle()

각종 핸들러: action()


## 17 -> 18
- action에 parameter menu 추가 -> getTitle() 받아서 쓰기 위함

### 배열이 있는 곳에 배열 다루는 코드 이관(캡슐화?)
- BoardRepository: 배열, length private 처리  
- add(Object object),  remove(index), toArray  
- (index), get(index), set(index, Object object) 

### 핸들러 수정

## 18 -> 19
- Object객체 사용해서 범용 Repository 생성  
-> ObjectRepository로 전부 변경
### 주의사항
리턴값이 object와 board 로 다른 경우에는 해당 타입으로 명시적 형변환을 해주어야 한다. 

## 19 -> 20 
### 제네릭 적용
- 기존 직접 구현한 add(), remove() 메서드 기능을 arraycopy(), copyof() 메서드를 사용하여 편하게 구현하고 T[] toArray(T[]) 메서드 추가

## 20 -> 21
- 목록을 다루는 기존 Repository 클래스를 자바 Collection API인 ArrayList로 교체

## 21 -> 22
- 접근범위 넓힐 이유 없는 필드들 private 처리
- vo 인스턴스 getter/setter 적용

## 22 -> 23
Generalization
- menuHandler 구현체의 공통 분모를 추출하여 수퍼클래스 정의
- 수퍼클래스를 추상 클래스로 정의
1. menuItem과 menuGroup에서 title을 추출하여 AbstractMenu 클래스 생성(추상클래스, title,getTitle(), setTitle())

2. Handler의 title을 출력하는 코드을 추출하여 AbstractMenuHandler 클래스 생성(printMenuTitle()) + 상속 후 메서드 오버라이딩 할 시 코드 재정의 되기 때문에 수퍼클래스 메서드 기능을 그대로 두고 기능을 추가할 필요가 있다.
  - 수퍼클래스 메서드 콜 (super.action(menu)) => 까먹을 위험성 있음
  - 추상메서드 설정, action(Menu menu) 메서드에 추상메서드 삽입하여 구현

3. 서브클래스가 사용하는 의존객체를 수퍼클래스(AbstractMenuHandler)에서 관리(prompt)
  - prompt를 추상클래스로 옮기고 생성자로 받음
  - 콘크리트 클래스 생성자에서 추상클래스에 구현한 생성자를 실행 super(prompt)

4. 서브클래스에서 .getTitle 쓸 수 있도록 Menu menu를 protected로 설정해서 보관

## 23 -> 24
java.util.Date 클래스 활용
1. Date 클래스 지정
2. Date 인스턴스로 add
3. format 형식 변경 (%3$tm..) 3$는 하나의 파라미터 지정

java.sql.Date
1. assignment 변경, 제출마감일 입력형식으로
2. Prompt inputDate 메서드 추가,
  + Prompt 리팩토링: 임시변수 매개변수로 변경? 


## 24 -> 25
RunTimeException 예외 처리: 예외 발생 시 내가 만든 소스를 찾아가기
1. addHandler에서 날짜 입력 형식 예외 처리
2. 메뉴 잘못 선택 시 예외 처리
  - Main 메서드에서 예외 처리
  - modifyHandler에서 예외 처리 
    - 문제: modify에서만 적용됨
  - inputInt에서 적용
    - 문제1: -1 return 시 정상값인지 구분할 수 없음
    - 문제2: 예외 문구 출력은 호출하는 쪽에서 해야된다.
3. try catch catch catch로 여러 예외 동시에 처리
  - 각각의 Exception에 따라 처리할 예외 설정 ex) NumberFormatException, IllegalArgumentException...
4. MenuItem, MenuGroup에 예외 처리


중요!
- 프로그램을 실행하다가 어느 지점에서 예외가 발생하면 해당 위치에서 적절한 조치를 취할 것이다.
- 다만, 그에 벗어나는 조치가 되지 않은 예외가 JVM에 보고되는 경우를 대비해 마지막 보루인 main()에서는 예외를 처리해야 한다!
- main()에서 마저 처리하지 않는다면 JVM에게 보고될 것이고, 개발자나 알아 볼 메시지를 출력하고 종료해버린다.