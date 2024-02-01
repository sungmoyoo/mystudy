package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;

public class OrderDeleteHandler extends AbstractMenuHandler {

  private OrderDao orderDao;

  public OrderDeleteHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (orderDao.delete(no) == 0) {
      System.out.println("주문 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
