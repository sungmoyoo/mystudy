package bitcamp.myapp;

public class AssignmentData {
  
  static AssignmentData d1 = new AssignmentData("", "", "");
  String title;
  String content;
  String deadline;
  
  public AssignmentData(String title, String content, String deadline) {
    this.title = title;
    this.content = content;
    this.deadline = deadline;
  }
  
  
  static void add() {
    System.out.println("과제 등록:");
    d1 = new AssignmentData(
        Prompt.input("과제명? "),
        Prompt.input("내용? "),
        Prompt.input("제출마감일? ")
    );
    
  }
  
  static void view() {
    System.out.println("과제 조회");
    System.out.printf("과제명: %s\n", d1.title);
    System.out.printf("내용: %s\n", d1.content);
    System.out.printf("제출마감일: %s\n", d1.deadline);
  }
  
  static void modify() {
    System.out.println("과제 변경");
    d1.title = Prompt.input("과제명(%s)? ", d1.title);
    d1.content = Prompt.input("내용(%s)? ", d1.content);
    d1.deadline = Prompt.input("제출마감일(%s)? ", d1.deadline);
  }
  
  static void delete() {
    System.out.println("과제 삭제");
    d1.title = "";
    d1.content = "";
    d1.deadline = "";
  }
}
