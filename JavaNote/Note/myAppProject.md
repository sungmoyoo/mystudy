

16-> 17 
Menu, MenuHandler 인터페이스 추가
Menu: MenuGroup, MenuItem
MenuHandler: 각종 핸들러들

- 인터페이스
Menu: execute(Prompt prompt), String getTitle()

Menuhandler: action()


MenuGroup: 생성자(title), menuSize, menus배열
execute(), printMenu(), getTitle(), add(), remove(), indexOf()

MenuItem: 생성자(title), 생성자(title, menuHandler), title, menuHandler
execute(), getTitle()

각종 핸들러: action()


17 -> 18
action에 parameter menu 추가 -> getTitle() 받아서 쓰기 위함

- 배열이 있는 곳에 배열 다루는 코드 이관(캡슐화?)

BoardRepository: 배열, length private 처리
add(Object object),  remove(index), toArray(index), get(index), set(index, object) 

- 핸들러 수정

18 -> 19
Object객체 사용해서 범용 Repository 생성
-> ObjectRepository로 전부 변경
주의사항
리턴값이 object와 board 로 다른 경우에는 해당 타입으로 명시적 형변환을 해주어야 한다. 

