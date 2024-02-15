package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;
  private TransactionManager txManager;

  public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao, TransactionManager txManager) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);

      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }

      Board board = new Board();
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(oldBoard.getCreatedDate());

      txManager.startTransaction();

      // 파일 추가/삭제? 반복.
      while (true) {
        int ModifyNo = prompt.inputInt("""
            파일 수정
            1. 추가
            2. 삭제
            3. 종료
            """);

        if (ModifyNo == 1) {
          AttachedFile file = new AttachedFile();
          file.setFilePath(prompt.input("추가할 파일? "));
          file.setBoardNo(no);

          attachedFileDao.add(file);

        } else if (ModifyNo == 2) {
          List<AttachedFile> oldFiles = attachedFileDao.findAllByBoardNo(no);
          for (AttachedFile file : oldFiles) {
            prompt.printf("%d. %s\n", file.getNo(), file.getFilePath());
          }
          int deleteFileNo = prompt.inputInt("삭제할 파일 번호?");
          if (attachedFileDao.delete(deleteFileNo) > 0) {
            prompt.printf("삭제되었습니다. 파일번호:[%d] \n", deleteFileNo);
          } else {
            prompt.println("유효하지 않는 파일번호입니다.");
          }

        } else if (ModifyNo == 3) {
          break;
        } else {
          prompt.println("잘못된 번호입니다.");
        }
      }

      boardDao.update(board);
      prompt.println("게시글을 변경했습니다.");

      txManager.commit();

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      System.out.println("게시글 변경 오류!");
      e.printStackTrace();
    }
  }
}
