package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardAddHandler implements MenuHandler {
  
  Prompt prompt;
  Board[] boards = new Board[3];
  int length;
  
  public BoardAddHandler(Prompt prompt) {
    this.prompt = prompt;
    
  }
  
  public void action() {
    System.out.println("과제 등록:");
    
    if (this.length == this.boards.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize / 2);
      
      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }
      
      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      this.boards = arr;
    }
    
    Board board = new Board();
    board.title = this.prompt.input("과제명? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");
    
    this.boards[this.length++] = board;
  }
}