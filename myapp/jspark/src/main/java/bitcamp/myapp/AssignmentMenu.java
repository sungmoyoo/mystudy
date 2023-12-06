package bitcamp.myapp;

public class AssignmentMenu {

  static void printMenu() {
    System.out.println(MainMenu.ANSI_BOLD_RED + "[과제]" + MainMenu.ANSI_CLEAR);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    AssignmentData ad = new AssignmentData("", "", "");
    printMenu();
    while (true) {
      String input = Prompt.input("메인/과제> ");

      switch (input) {
        case "1":
          ad.add();
          break;
        case "2":
          ad.view();
          break;
        case "3":
          ad.modify();
          break;
        case "4":
          ad.delete();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }


}
