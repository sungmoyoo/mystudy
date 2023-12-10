package bitcamp.myapp;

public class MainMenu {
  
  static final String FONT_RED = "\u001B[1;31m";
  static final String RESET = "\u001B[0m";
  static final String appTitle = "[과제관리 시스템]";
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시판",
      "3. 도움말",
      "4. 종료"
  };
  
  
  static void printMenu() {
    System.out.println(FONT_RED + appTitle + RESET);
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }
  
  static void execute() {
    while (true) {
      printMenu();
      String input = Prompt.input("메인> ");
      
      switch (input) {
        case "1":
          AssignmentMenu.execute();
          break;
        case "2":
          BoardMenu.execute();
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴번호가 옳지 않습니다");
      }
    }
  }
}