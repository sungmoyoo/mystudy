## 16-> 17 
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
