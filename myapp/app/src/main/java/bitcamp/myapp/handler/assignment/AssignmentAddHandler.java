package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.List;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;


  public AssignmentAddHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명? "));
      assignment.setContent(this.prompt.input("내용? "));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

      this.objectRepository.add(assignment);
    } catch (Exception E) {
      System.out.println("올바르지 않은 날짜 형식입니다.");
    }
  }
}
