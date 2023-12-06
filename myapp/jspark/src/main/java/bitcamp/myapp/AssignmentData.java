package bitcamp.myapp;

public class AssignmentData {

  String title;
  String content;
  String deadline;

  public AssignmentData(String title, String content, String deadline) {
    this.title = title;
    this.content = content;
    this.deadline = deadline;
  }

  void add() {
    System.out.println("과제 등록:");
    this.title = Prompt.input("과제명? ");
    this.content = Prompt.input("내용? ");
    this.deadline = Prompt.input("제출 마감일? ");

  }

  void view() {
    System.out.println("과제 조회:");
    System.out.printf("과제명 : %s\n", this.title);
    System.out.printf("내용 : %s\n", this.content);
    System.out.printf("제출 마감일 : %s\n", this.deadline);
  }

  void modify() {
    System.out.println("과제 변경:");
    this.title = Prompt.input("과제명(%s)? ", title);
    this.content = Prompt.input("내용(%s)? ", content);
    this.deadline = Prompt.input("제출 마감일(%s)? ", deadline);
  }

  void delete() {
    System.out.println("과제 삭제:");
    this.title = "";
    this.content = "";
    this.deadline = "";
  }
}
