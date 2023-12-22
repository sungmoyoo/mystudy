package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;


  public AssignmentModifyHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {

    try {
      int index = this.prompt.inputInt("번호? ");
      Assignment old = this.objectRepository.get(index);
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명(%s)? ", old.getTitle()));
      assignment.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));
      this.objectRepository.set(index, assignment);

    } catch (Exception e) {
      System.out.println("실행 오류!");
    }
  }
}
