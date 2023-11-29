package bitcamp.myapp;

import java.util.Scanner;

public class App {
  
  // 애플리케이션 객체 App을 실행할 때 다음 변수를 미리 준비해준다.
  static final String RESET = "\033[0m";
  static final String RED_BOLD = "\033[1;31m";
  static final String APP_TITLE = RED_BOLD + "[과제 관리 시스템]" + RESET;
  static final String[] MENU_LIST = {
      APP_TITLE,
      "-------------------",
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      "4. 종료",
      "-------------------"
  };
  static final Scanner keyIn = new Scanner(System.in);
  
  public static void main(String[] args) {
    printMenu();
    
    label:
    while (true) {
      switch (prompt()) {
        case "1":
          System.out.println("과제입니다.");
          System.out.println();
          break;
        case "2":
          System.out.println("게시글입니다.");
          System.out.println();
          break;
        case "3":
          System.out.println("도움말입니다.");
          System.out.println();
          break;
        case "4":
          System.out.println("종료합니다.");
          break label;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("잘못된 번호입니다.");
          System.out.println();
          break;
      }
    }
    keyIn.close();
  }
  
  // ANSI 코드와 App제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에 클래스 블록 안에 두면
  // printMenu()를 호출할 때마다 변수를 만들지 않기 때문에 실행 속도나 메모리 부분에서 훨씬 효율적이다.
  // 보통 메서드 호출될 때마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우 메서드 밖에 두는 것이 좋다.
  static void printMenu() {
    for (String menu : MENU_LIST) {
      System.out.println(menu);
    }
  }
  
  static String prompt() {
    System.out.print("> ");
    return keyIn.nextLine();
  }
}
