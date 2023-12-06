package bitcamp.myapp;

public class BoardData {

  String title;
  String content;
  String writer;
  String createDate;

  public BoardData(String title, String content, String writer, String createDate) {
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.createDate = createDate;
  }

  void add() {
    System.out.println("게시글 등록:");
    this.title = Prompt.input("제목? ");
    this.content = Prompt.input("내용? ");
    this.writer = Prompt.input("작성자? ");
    this.createDate = Prompt.input("작성일? ");
  }

  void view() {
    System.out.println("게시글 조회:");
    System.out.printf("제목 : %s\n", this.title);
    System.out.printf("내용 : %s\n", this.content);
    System.out.printf("작성자 : %s\n", this.writer);
    System.out.printf("작성일 : %s\n", this.createDate);
  }

  void modify() {
    System.out.println("게시글 변경:");
    this.title = Prompt.input("제목(%s)? ", title);
    this.content = Prompt.input("내용(%s)? ", content);
    this.writer = Prompt.input("작성자(%s)? ", writer);
    this.createDate = Prompt.input("작성일(%s)? ", createDate);
  }

  void delete() {
    System.out.println("게시글 삭제:");
    this.title = "";
    this.content = "";
    this.writer = "";
    this.createDate = "";
  }
}
