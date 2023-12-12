package bitcamp.myapp.handler.assignment;

import bitcamp.menu.MenuHandler;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {
  
  AssignmentRepository assignmentRepository;
  Prompt prompt;
  
  public AssignmentDeleteHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }
  
  @Override
  public void action() {
    System.out.println("과제 삭제:");
    
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.assignmentRepository.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    
    for (int i = index; i < (this.assignmentRepository.length - 1); i++) {
      this.assignmentRepository.assignments[i] = this.assignmentRepository.assignments[i + 1];
    }
    this.assignmentRepository.length--;
    this.assignmentRepository.assignments[this.assignmentRepository.length] = null;
  }
}
