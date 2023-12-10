package bitcamp.myapp;

import java.util.Scanner;

public class BoardMenu {
  
  static Scanner keyIn = new Scanner(System.in);
  
  static void printMenu() {
    System.out.println("[게시판]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }
  
  static void execute() {
    while (true) {
      printMenu();
      String input = Prompt.input("메인/게시판");
      
      switch (input) {
        case "1":
          System.out.println("게시글 등록입니다.");
          break;
        case "2":
          System.out.println("게시글 조회입니다.");
          break;
        case "3":
          System.out.println("게시글 변경입니다.");
          break;
        case "4":
          System.out.println("게시글 삭제입니다.");
          break;
        case "0":
          System.out.println("이전");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("유효하지 않은 번호입니다.");
      }
    }
  }
}