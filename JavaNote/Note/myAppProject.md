## 1
- Gradle 빌드 도구를 이용하여 프로젝트 폴더를 구성하는 방법
  - `init` task 실행
- Gradle로 프로젝트를 빌드하고 실행하는 방법
  - `build`, `run` task 실행

## 2
- 문자열 출력
- 줄바꿈, 이스케이프문자, 포맷 문자열 활용
```
----------------------------------------------
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
----------------------------------------------
```
## 3
- ANSI 이스케이프 코드를 사용하여 출력 문자열 꾸미기

## 4
- ANSI CODE를 변수에 저장하여 사용

## 5 
- 표준입력스트림에서 값을 입력받기(Prompt)
- 조건문, 반복문을 통해 메인메뉴 출력
```
----------------------------------------------
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
> 1
과제입니다.
> 2
게시글입니다.
> 3
도움말입니다.
> 4
종료합니다. <=== 프로그램 종료!
> menu
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
----------------------------------------------
```
## 6
- 배열과 반복문을 활용하여 아래 작업 실시
```
1. 메뉴를 배열에 저장한다.
2. 메뉴 목록을 출력할 때 배열에서 꺼내 출력한다.
```

## 7
- 메서드 활용하여 중복코드 제거
- static 필드, 메서드 사용
## 8
- 조건문, 메서드 사용하여 각 메뉴에 대해 아래와 같이 서브 메뉴를 출력
```
----------------------------------------------
[과제관리 시스템]

1. 과제
2. 게시글
3. 도움말
4. 종료
메인> 1
[과제]
1. 등록
2. 조회
3. 변경
4. 삭제
0. 이전
메인/과제> 1
과제 등록입니다.
메인/과제> 2
과제 조회입니다.
메인/과제> 3
과제 변경입니다.
메인/과제> 4
과제 삭제입니다.
메인/과제> menu
[과제]
1. 등록
2. 조회
3. 변경
4. 삭제
0. 이전
메인/과제> 0
메인>
----------------------------------------------
```

## 9
메서드를 역할에 따라 분류하기: 클래스


## 10
- CRUD 구현  
  xxxMenu에 메서드 구현
  - add()
  - list()
  - view()
  - modify()
  - delete()

## 11
- 사용자 정의 데이터 타입 용도의 클래스 생성
- board, assignment, member에서 사용할 클래스 생성 후 객체를 생성하여 사용

## 12
- 레퍼런스 배열 다루기
- 입력값(객체)을 저장하는 레퍼런스 배열을 생성, 확장, 조회, 출력하는 기능 구현

## 13
- 회원 메뉴 추가하고 CRUD 구현  
  xxxMenu에 메서드 구현, 10번과 동일
  - add()
  - list()
  - view()
  - modify()
  - delete()


## 14
- 스태틱 필드 한계 확인
- 변경사항 없음

## 15
- BoardMenu, AssignmentMenu, MemberMenu에 인스턴스 메서드 적용
- Prompt에 inputInt(), inputFloat(), inputBoolean() 메서드 추가
- 생성자를 통해 Prompt 객체를 XxxMenu에 주입
- ANSI Escape Sequence 값을 별도의 클래스로 분리
- 클래스를 패키지로 분류

## 16
- 인터페이스 문법으로 메뉴를 다루는 객체의 실행 규칙 정의 (Menu ...)
- 인터페이스에 정의한 대로 메뉴를 다루는 객체를 구현 (App)
- 인터페이스에 정의한 대로 메뉴를 다루는 객체를 실행 (mainMenu.execute)


## 17 
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


## 18
- action에 parameter menu 추가 -> getTitle() 받아서 쓰기 위함

### 배열이 있는 곳에 배열 다루는 코드 이관(캡슐화?)
- BoardRepository: 배열, length private 처리  
- add(Object object),  remove(index), toArray  
- (index), get(index), set(index, Object object) 

### 핸들러 수정

## 19
- Object객체 사용해서 범용 Repository 생성  
-> ObjectRepository로 전부 변경
### 주의사항
리턴값이 object와 board 로 다른 경우에는 해당 타입으로 명시적 형변환을 해주어야 한다. 

## 20 
### 제네릭 적용
- 기존 직접 구현한 add(), remove() 메서드 기능을 arraycopy(), copyof() 메서드를 사용하여 편하게 구현하고 T[] toArray(T[]) 메서드 추가

## 21
- 목록을 다루는 기존 Repository 클래스를 자바 Collection API인 ArrayList로 교체

## 22
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

## 24
java.util.Date 클래스 활용
1. java.util.Date import, 
2. Date 인스턴스로 add
3. format 형식 변경 (%3$tm..) 3$는 하나의 파라미터 지정

java.sql.Date
1. assignment 변경, 제출마감일 입력형식으로
2. Prompt inputDate 메서드 추가,
  + Prompt 리팩토링: 임시변수 매개변수로 변경? 


## 25
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

## 26
자료구조-LinkedList
- LinkedList, Node 클래스 생성
- Node에 value, next 변수 선언

- LinkedList add() 메서드 생성
```
value는 Object value값 저장
next는 다음 노드의 주소를 저장하여 연결
```

- LinkedList toArray() 메서드 생성
```
1. arr[] 생성
2. Node는 first부터, index는 0부터
3. node가 null이 아닐때까지 반복하여 arr[index]에 value 저장
4. arr 리턴
```

- LinkedList get() 메서드 생성
```
1.index 유효범위 아닐 때 IndexOutOfBoundException throw
2.현재 위치를 int cursor = 0으로 설정
3.node는 first부터, cursor가 index와 같아질 때까지 반복, node.next로 다음 주소를 node에 저장
4. index와 cursor와 같아지면 반복 종료 후 node.value 리턴
```

- LinkedList set() 메서드 생성
```
1. 인덱스를 찾아가는 과정은 동일
2. 기존 값을 old에 저장, 새로운 값 node.value에 저장
3. old 리턴
```

- LinkedList add(index, value) 삽입하는 메서드 생성
```
1. 인덱스 유효성 검사
2. 새 노드 객체 생성, value 저장
3. 값이 없을 때: first, last 모두 node 주소 저장
4. 인덱스가 0일 때: 새 노드 객체를 first, first에 node를 저장
5. 인덱스가 size일 때: last.next를 추가된 node 주소로 바꾸고 last를 node로 바꾼다.
6. 인덱스가 중간일 때(나머지): 
  - 현 노드가 존재하는 위치를 저장하기 위해 cursor 설정
  - 새 객체 currNode를 생성하고 주소를 first로 설정
  - 인덱스 전까지 node를 반복 이동
  - node.next를 currNode.next로 교체
7. size 확장
```

- LinkedList remove(index) 메서드 생성
```
1. 인덱스 유효성 검사
2. 값이 1개일 때: first, last 모두 null
3. 맨 앞: first 주소를 first.next로 교체
4. 맨 뒤: size-1에서 currNode.next를 last값으로 교체
5. 중간: 인덱스-1에서 currNode.next를 currNode.next.next값으로 교체
6. 리팩토링: 조건문 공통코드 슬라이드
  - 중복되는 반복문 else문에 넣고 닫기
  - 중간 값 계산
  - 마지막 값 if문으로 묶고 last값 바꾸기
```

- 중첩 클래스 정의
```
node 클래스를 LinkedList 클래스 안으로 복사 후 private static 처리
```

- 제네릭 적용
```
<E> E 추가
```

- MenuGroup LinkedList 적용
```
1. LinkedList<Menu> 생성
2. 특정 인덱스 지정은 get() 메서드 호출
3. Menusize 제거 menus.size() getter 사용
4. add, remove 메서드 호출로 변경
```

- boolean remove(E value) 메서드 생성
```
1. prevNode = Null로 생성, node는 first로 생성
2. node != null 아닐때 반복, if Value값 같으면 break
3. node가 null 되면 false return
4. node가 첫번째일때 다음 노드를 first로 설정
5. 근데 first가 null이면 값이 하나이므로 last도 null처리
6. prevNode.next에 node.next로 노드 하나 삭제
```