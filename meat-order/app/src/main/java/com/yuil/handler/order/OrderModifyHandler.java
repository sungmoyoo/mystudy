package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.vo.Order;

public class OrderModifyHandler extends AbstractMenuHandler {

  private OrderDao orderDao;
  Choice c = new Choice(prompt);
  public OrderModifyHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Order oldBoard = orderDao.findBy(no);
    if (oldBoard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Order board = new Order();
    board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    board.setClassification(c.getTypeChoice());
    board.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
    board.setCreatedDate(oldBoard.getCreatedDate());

    boardDao.update(board);
    System.out.println("게시글을 변경했습니다.");
  }
}
