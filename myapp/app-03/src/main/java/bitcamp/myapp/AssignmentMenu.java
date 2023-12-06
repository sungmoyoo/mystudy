package bitcamp.myapp;

public class AssignmentMenu {
  
  
  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }
  
  static void execute() {
    
    while (true) {
      printMenu();
      String input = Prompt.input("메인/과제> ");
      
      switch (input) {
        case "1":
          AssignmentData.add();
          break;
        case "2":
          AssignmentData.view();
          break;
        case "3":
          AssignmentData.modify();
          break;
        case "4":
          AssignmentData.delete();
          break;
        case "0":
          return;
        case "menu":
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }
  
  
}
