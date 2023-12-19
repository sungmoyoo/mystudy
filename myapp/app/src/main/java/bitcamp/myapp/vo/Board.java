package bitcamp.myapp.vo;

public class Board {

  private String title;
  private String content;
  private String writer;
  private String createdDate;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return this.writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
}
