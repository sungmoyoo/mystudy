package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.vo.User;

public class OrderViewHandler extends AbstractMenuHandler {

  private OrderDao orderDao;

  public OrderViewHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("주문 번호? ");

    User order = orderDao.findBy(no);
    if (order == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("주민번호: %d\n", order.getOrderNo());
    System.out.printf("종류: %s\n", order.getClassification());
    System.out.printf("상품명: %s\n", order.getProductName());
    System.out.printf("수량: %s\n", order.getCount());
    System.out.printf("주문일: %1$tY-%1$tm-%1$td\n", order.getOrderDate());
  }
}
