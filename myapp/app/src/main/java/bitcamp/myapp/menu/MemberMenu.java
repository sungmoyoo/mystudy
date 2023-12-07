package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu {
  
  String title;
  Member[] members = new Member[3];
  int length = 0;
  Prompt prompt;
  
  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }
  
  static void printMenu() {
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }
  
  void execute() {
    printMenu();
    
    while (true) {
      String input = this.prompt.input("메인/회원> ");
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
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
  
  void add() {
    System.out.println("회원 등록:");
    if (this.length == this.members.length) {
      int oldSize = this.members.length;
      int newSize = oldSize + (oldSize >> 2);
      
      Member[] arr = new Member[newSize];
      for (int i = 0; i < this.members.length; i++) {
        arr[i] = this.members[i];
      }
      
      this.members = arr;
    }
    
    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("암호? ");
    member.createdDate = this.prompt.input("가입일? ");
    
    this.members[this.length++] = member;
    
    
  }
  
  void view() {
    System.out.println("회원 정보 조회");
    
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }
    
    Member member = this.members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("암호: %s\n", member.password);
    System.out.printf("가입일: %s\n", member.createdDate);
  }
  
  void modify() {
    System.out.println("회원 정보 변경");
    
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= length) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }
    
    Member member = this.members[index];
    member.email = this.prompt.input("이메일(%s)? ", member.email);
    member.name = this.prompt.input("이름(%s)? ", member.name);
    member.password = this.prompt.input("암호(%s)? ", member.password);
    member.createdDate = this.prompt.input("가입일(%s)? ", member.createdDate);
  }
  
  void list() {
    System.out.println("회원 목록 조회");
    
    System.out.printf("%-20s\t%10s\t%s\n", "이메일", "이름", "가입일");
    
    for (int i = 0; i < this.length; i++) {
      Member member = this.members[i];
      System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createdDate);
    }
  }
  
  void delete() {
    System.out.println("회원 정보 삭제");
    
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }
    
    for (int i = index; i < (this.length - 1); i++) {
      this.members[i] = this.members[i + 1];
    }
    
    this.members[--this.length] = null;
  }
  
  
}
