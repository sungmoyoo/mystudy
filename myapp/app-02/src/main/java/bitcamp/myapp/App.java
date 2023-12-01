package bitcamp.myapp;

import java.util.Scanner;

public class App {
  
  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "------------",
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      "4. 종료",
      "------------"
  };
  
  static final String[] sub = {"과제", "게시글", "도움말"};
  
  
  public static void main(String[] args) {
    
    printMainMenu();
    
    Scanner keyIn = new Scanner(System.in);
    
    loop:
    while (true) {
      String input = prompt("메인", keyIn);
      
      switch (input) {
        case "1":
          onSubMenu(sub[0], keyIn);
          break;
        case "2":
          onSubMenu(sub[1], keyIn);
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          printMainMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    
    keyIn.close();
  }
  
  static void printMainMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }
  
  static void printSub(String sub) {
    System.out.println();
    System.out.println("[" + sub + "]");
    System.out.println("------------");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
    System.out.println("------------");
  }
  
  static String prompt(String title, Scanner keyIn) {
    System.out.printf("%s> ", title);
    return keyIn.nextLine();
  }
  
  static void onSubMenu(String sub, Scanner keyIn) {
    printSub(sub);
    
    while (true) {
      String input = prompt("메인/" + sub, keyIn);
      switch (input) {
        case "1":
          System.out.println("등록입니다.");
          break;
        case "2":
          System.out.println("조회입니다.");
          break;
        case "3":
          System.out.println("변경입니다.");
          break;
        case "4":
          System.out.println("삭제입니다.");
          break;
        case "0":
          printMainMenu();
          return;
        case "menu":
          printSub(sub);
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }
  
}
