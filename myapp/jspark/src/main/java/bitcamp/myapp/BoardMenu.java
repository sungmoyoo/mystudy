package bitcamp.myapp;

public class BoardMenu {

  static void printMenu() {
    System.out.println(MainMenu.ANSI_BOLD_RED + "[게시글]" + MainMenu.ANSI_CLEAR);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
//    BoardData bd = new BoardData(Prompt.input("제목? "), Prompt.input("내용? "), Prompt.input("작성자? "),
//        Prompt.input("작성일? "));
    BoardData bd = new BoardData("", "", "", "");
    printMenu();

    while (true) {
      String input = Prompt.input("메인/게시글> ");

      switch (input) {
        case "1":
          bd.add();
          break;
        case "2":
          bd.view();
          break;
        case "3":
          bd.modify();
          break;
        case "4":
          bd.delete();
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
