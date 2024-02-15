package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.sql.Connection;
import java.util.ArrayList;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private TransactionManager txManager;
  private AttachedFileDao attachedFileDao;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.txManager = txManager;
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    ArrayList<AttachedFile> files = new ArrayList<>();

    while (true) {
      String filepath = prompt.input("파일?(종료는 enter) ");
      if (filepath.length() == 0) {
        break;
      }
      files.add(new AttachedFile().filePath(filepath));
    }

    try {
      txManager.startTransaction();

      boardDao.add(board);

      if (files.size() > 0) {
        // 첨부파일 객체에 게시글 번호 저장
        for (AttachedFile file : files) {
          file.setBoardNo(board.getNo());
        }

        attachedFileDao.addAll(files);
      }

      txManager.commit();

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      prompt.println("게시글 등록 오류!");
      e.printStackTrace();
    }
  }
}