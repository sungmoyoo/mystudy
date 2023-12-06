package bitcamp.myapp;

public class MemberMenu {
  
  static Member[] members = new Member[3];
  static int length;
  
  static void printMenu() {
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 상세조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }
  
  static void execute() {
    printMenu();
    
    while (true) {
      String input = Prompt.input("메인/회원> ");
      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
        default:
          System.out.println("메뉴번호가 옳지 않습니다.");
      }
    }
  }
  
  static void add() {
    System.out.println("회원 등록:");
    if (length == members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize >> 2);
      Member[] arr = new Member[newSize];
      
      for (int i = 0; i < length; i++) {
        arr[i] = members[i];
      }
      members = arr;
    }
    
    Member member = new Member();
    member.email = Prompt.input("이메일? ");
    member.name = Prompt.input("이름? ");
    member.pw = Prompt.input("암호? ");
    member.signDate = Prompt.input("가입일? ");
    
    members[length++] = member;
  }
  
  static void list() {
    System.out.println("회원 정보 목록:");
    System.out.printf("%-15s\t%10s\t%10s\t%10s\n", "이메일", "이름", "암호", "가입일");
    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-20s\t%10s\t%10s\t%10s\n", member.email, member.name, member.pw,
          member.signDate);
    }
  }
  
  static void view() {
    System.out.println("회원 정보 조회:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      return;
    }
    Member member = members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("암호: %s\n", member.pw);
    System.out.printf("가입일: %s\n", member.signDate);
  }
  
  static void modify() {
    System.out.println("회원 정보 수정:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      return;
    }
    Member member = members[index];
    member.email = Prompt.input("이메일(%s)? ", member.email);
    member.name = Prompt.input("이름(%s)? ", member.name);
    member.pw = Prompt.input("암호(%s)? ", member.pw);
    member.signDate = Prompt.input("가입일(%s)? ", member.signDate);
  }
  
  static void delete() {
    System.out.println("회원 정보 삭제");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      return;
    }
    
    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    
    members[--length] = null;
  }
}
